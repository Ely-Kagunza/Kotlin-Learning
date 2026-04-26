package org.example.day1

enum class BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
}

class CinemaBooking(
    val bookingId: String,
    val customerName: String,
    val movieTitle: String,
    val requestedSeats: Int,
    val availableSeats: Int
) {
    private var _status = BookingStatus.PENDING

    val status: BookingStatus
        get() = _status

    init {
        require(bookingId.isNotBlank()) { "Booking ID must not be blank" }
        require(customerName.isNotBlank()) { "Customer name must not be blank" }
        require(movieTitle.isNotBlank()) { "MovieTitle must not be blank" }
        require(requestedSeats > 0) { "Requested seats must be greater than zero" }
        require(availableSeats >= 0) { "Available seats must be 0 or greater" }
    }

    fun confirm() {
        check(status == BookingStatus.PENDING) { "Booking status must be 'PENDING'" }
        _status = BookingStatus.CONFIRMED
    }

    fun cancel() {
        check(status == BookingStatus.PENDING) { "Booking status must be 'PENDING'" }
        _status = BookingStatus.CANCELLED
    }
}

sealed class BookingResult {
    data class BookingSuccess(val bookingId: String, val movieTitle: String, val seatsBooked: Int) : BookingResult()
    data class NotEnoughSeats(val requestedSeats: Int, val availableSeats: Int) : BookingResult()
    data class AlreadyFinalized(val bookingId: String, val currentStatus: BookingStatus) : BookingResult()
}

object CinemaBookingService {
    fun processBooking(booking: CinemaBooking): BookingResult {
        return booking.run {
            when {
                status != BookingStatus.PENDING -> BookingResult.AlreadyFinalized(bookingId, status)
                requestedSeats > availableSeats -> BookingResult.NotEnoughSeats(requestedSeats, availableSeats)
                else -> {
                    confirm()
                    BookingResult.BookingSuccess(bookingId, movieTitle, requestedSeats)
                }
            }
        }
    }
}

fun main() {
    val booking = CinemaBooking(
        "B_101",
        "Elly",
        "Person Of Interest",
        5,
        10
    )
    booking.cancel()

    println(CinemaBookingService.processBooking(booking))
}