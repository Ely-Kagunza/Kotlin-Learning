package org.example.finalproject.cinetrack.services

import kotlinx.coroutines.delay
import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.Booking.Companion.totalBookings
import org.example.finalproject.cinetrack.models.BookingStatus
import org.example.finalproject.cinetrack.results.PaymentResult

class PaymentService {
    suspend fun processPayment(booking: Booking): PaymentResult {
        delay(1000)
        return when {
            booking.totalAmount <= 0 -> {
                PaymentResult.Failed("Total should be greater than zero")
            }

            booking.status != BookingStatus.CONFIRMED -> {
                PaymentResult.Failed("Status should be 'CONFIRMED'")
            }

            else -> {
                booking.markPaid()
                PaymentResult.Success("TXN-{${booking.bookingId}}", booking.totalAmount)
            }
        }
    }
}