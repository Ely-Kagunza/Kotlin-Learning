package org.example.finalproject.cinetrack.monitor

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import org.example.finalproject.cinetrack.repository.CinemaRepository
import org.example.finalproject.cinetrack.results.BookingResult
import org.example.finalproject.cinetrack.results.PaymentResult
import org.example.finalproject.cinetrack.services.BookingService
import org.example.finalproject.cinetrack.services.PaymentService
import org.example.finalproject.cinetrack.state.CinemaUiEvent
import org.example.finalproject.cinetrack.state.CinemaUiState

class BookingMonitor(
    private val repository: CinemaRepository,
    private val bookingService: BookingService,
    private val paymentService: PaymentService
) {
    private val _state = MutableStateFlow(CinemaUiState())
    val state: StateFlow<CinemaUiState> = _state.asStateFlow()

    private val _event = MutableSharedFlow<CinemaUiEvent>()
    val event: SharedFlow<CinemaUiEvent> = _event.asSharedFlow()

    suspend fun loadMovies() {
        _state.update { current ->
            current.copy(
                loading = true,
                error = null
            )
        }

        val movies = repository.fetchMovies()

        _state.update { current ->
            current.copy(
                loading = false,
                movies = movies,
                error = null
            )
        }
    }

    suspend fun processBookingEvents() = coroutineScope {
        repository.bookingEvents().collect { bookingEvent ->
            val result = runCatching {
                val customer = repository.fetchCustomer(bookingEvent.customerId)
                    ?: error("Customer not found: ${bookingEvent.customerId}")

                val movie = _state.value.movies.find { movie ->
                    movie.id == bookingEvent.movieId
                } ?: error("Movie not found: ${bookingEvent.movieId}")

                when (val bookingResult = bookingService.processBooking(customer, movie, bookingEvent.seatsRequested)) {
                    is BookingResult.Success -> {
                        val booking = bookingResult.booking

                        val paymentResult = async {
                            paymentService.processPayment(booking)
                        }.await()

                        when (paymentResult) {
                            is PaymentResult.Success -> {
                                _state.update { current ->
                                    current.copy(
                                        processedBookings = current.processedBookings + booking,
                                        totalRevenue = current.totalRevenue + paymentResult.amount
                                    )
                                }

                                _event.emit(
                                    CinemaUiEvent.BookingConfirmed(
                                        "Booking ${booking.bookingId} confirmed"
                                    )
                                )

                                _event.emit(
                                    CinemaUiEvent.PaymentCompleted(
                                        "Payment ${paymentResult.transactionId} completed"
                                    )
                                )
                            }

                            is PaymentResult.Failed -> {
                                rejectBookingEvent(
                                    bookingEvent = bookingEvent,
                                    reason = paymentResult.reason
                                )
                            }

                            PaymentResult.Processing -> {
                                _event.emit(
                                    CinemaUiEvent.Error("Payment still processing")
                                )
                            }
                        }
                    }

                    is BookingResult.NotEnoughSeats -> {
                        rejectBookingEvent(
                            bookingEvent = bookingEvent,
                            reason = "Not enough seats for movie ${bookingResult.movieId}"
                        )
                    }

                    is BookingResult.InvalidCustomer -> {
                        rejectBookingEvent(
                            bookingEvent = bookingEvent,
                            reason = bookingResult.reason
                        )
                    }

                    is BookingResult.AlreadyFinalized -> {
                        rejectBookingEvent(
                            bookingEvent = bookingEvent,
                            reason = "Booking ${bookingResult.bookingId} already finalized"
                        )
                    }

                    BookingResult.Processing -> {
                        _event.emit(
                            CinemaUiEvent.Error("Booking still processing")
                        )
                    }
                }
            }

            val error = result.exceptionOrNull()
            if (error != null) {
                rejectBookingEvent(
                    bookingEvent = bookingEvent,
                    reason = error.message ?: "Unknown processing error"
                )
            }
        }
    }

    private suspend fun rejectBookingEvent(
        bookingEvent: BookingEvent,
        reason: String
    ) {
        _state.update { current ->
            current.copy(
                rejectedEvents = current.rejectedEvents + bookingEvent
            )
        }

        _event.emit(
            CinemaUiEvent.BookingRejected(reason)
        )
    }
}