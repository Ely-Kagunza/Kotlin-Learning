package org.example.finalproject.cinetrack

import kotlinx.coroutines.async
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.BookingStatus
import org.example.finalproject.cinetrack.models.Customer
import org.example.finalproject.cinetrack.models.Movie
import org.example.finalproject.cinetrack.models.MovieCategory
import org.example.finalproject.cinetrack.monitor.BookingMonitor
import org.example.finalproject.cinetrack.repository.CinemaRepository
import org.example.finalproject.cinetrack.results.BookingResult
import org.example.finalproject.cinetrack.services.BookingService
import org.example.finalproject.cinetrack.services.PaymentService
import org.example.finalproject.cinetrack.state.CinemaUiEvent
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class BookingServiceTest {
    @Test
    fun `successful booking returns success`() {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 5)

        assertTrue { result is BookingResult.Success }
    }

    @Test
    fun `success confirms booking`() {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 5)

        val success = result as BookingResult.Success

        assertEquals (BookingStatus.CONFIRMED, success.booking.status)
    }

    @Test
    fun `invalid email returns invalid customer`() {
        val customer = Customer("C-1", "John", "johngmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 5)

        assertTrue { result is BookingResult.InvalidCustomer }
    }

    @Test
    fun `not enough seats returns NotEnoughSeats`() {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 2)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 5)

        assertTrue { result is BookingResult.NotEnoughSeats }
    }

    @Test
    fun `booking total is calculated correctly`() {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 5)

        val success = result as BookingResult.Success

        assertEquals(1500.0, success.booking.calculateTotal())
    }

    @Test
    fun `bookings cannot be confirmed twice`() {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 5)

        val success = result as BookingResult.Success

        assertFailsWith<IllegalStateException> {
            success.booking.confirm()
        }
    }

    @Test
    fun `events are emitted`() = runBlocking {
        val repo = CinemaRepository()
        val bookingService = BookingService()
        val paymentService = PaymentService()
        val monitor = BookingMonitor(repo, bookingService, paymentService)

        val eventsDeferred = async {
            monitor.event
                .take(8)
                .toList()
        }

        monitor.loadMovies()
        monitor.processBookingEvents()

        val events = eventsDeferred.await()

        assertTrue(events.any { it is CinemaUiEvent.BookingConfirmed })
        assertTrue(events.any { it is CinemaUiEvent.PaymentCompleted })
        assertTrue(events.any { it is CinemaUiEvent.BookingRejected })
    }
}