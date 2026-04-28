package org.example.finalproject.cinetrack

import kotlinx.coroutines.runBlocking
import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.Customer
import org.example.finalproject.cinetrack.models.Movie
import org.example.finalproject.cinetrack.models.MovieCategory
import org.example.finalproject.cinetrack.models.PaymentStatus
import org.example.finalproject.cinetrack.results.BookingResult
import org.example.finalproject.cinetrack.results.PaymentResult
import org.example.finalproject.cinetrack.services.BookingService
import org.example.finalproject.cinetrack.services.PaymentService
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PaymentServiceTest {
    @Test
    fun `confirmed booking with total greater than 0 returns success`() {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 4)

        assertTrue { result is BookingResult.Success }
    }

    @Test
    fun `payment success marks booking paid`() = runBlocking {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)
        val bookingService = BookingService()

        val result = bookingService.processBooking(customer, movie, 4)

        val success = result as BookingResult.Success

        val paymentService = PaymentService()
        paymentService.processPayment(success.booking)

        assertEquals (PaymentStatus.PAID, success.booking.paymentStatus)
    }

    @Test
    fun `booking not confirmed returns failed`() = runBlocking {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)

        val booking = Booking.create(customer, movie, 4)
        booking.calculateTotal()
        val paymentService = PaymentService()

        val result = paymentService.processPayment(booking)

        assertTrue { result is PaymentResult.Failed }
    }

    @Test
    fun `zero total booking returns failed`() = runBlocking {
        val customer = Customer("C-1", "John", "john@gmail.com", 100)
        val movie = Movie("MV-1", "Person", MovieCategory.ANIMATION, 30, 300.0, 10)

        val booking = Booking.create(customer, movie, 4)
        booking.confirm()
        val paymentService = PaymentService()

        val result = paymentService.processPayment(booking)

        assertTrue { result is PaymentResult.Failed }
    }
}