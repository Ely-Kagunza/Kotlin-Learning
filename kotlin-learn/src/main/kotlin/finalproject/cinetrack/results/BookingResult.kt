package org.example.finalproject.cinetrack.results

import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.BookingStatus

sealed class BookingResult {
    data class Success(val booking: Booking) : BookingResult()
    data class NotEnoughSeats(val movieId: String, val requested: Int, val available: Int) : BookingResult()
    data class InvalidCustomer(val reason: String) : BookingResult()
    data class AlreadyFinalized(val bookingId: String, val status: BookingStatus) : BookingResult()
    data object Processing : BookingResult()
}