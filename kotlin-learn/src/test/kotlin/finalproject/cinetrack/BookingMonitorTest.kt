package org.example.finalproject.cinetrack

import kotlinx.coroutines.runBlocking
import org.example.finalproject.cinetrack.monitor.BookingMonitor
import org.example.finalproject.cinetrack.repository.CinemaRepository
import org.example.finalproject.cinetrack.services.BookingService
import org.example.finalproject.cinetrack.services.PaymentService
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BookingMonitorTest {
    @Test
    fun `initial state is empty`() {
        val repo = CinemaRepository()
        val bookingService = BookingService()
        val paymentService = PaymentService()
        val monitor = BookingMonitor(repo, bookingService, paymentService)

//        assertTrue { monitor.state is  }
    }

    @Test
    fun `loading movies updates state movies`() = runBlocking {
        val repo = CinemaRepository()
        val bookingService = BookingService()
        val paymentService = PaymentService()
        val monitor = BookingMonitor(repo, bookingService, paymentService)

        monitor.loadMovies()

        assertTrue { monitor.state.value.movies.isNotEmpty() }
    }

    @Test
    fun `processing events increases processed bookings`() = runBlocking {
        val repo = CinemaRepository()
        val bookingService = BookingService()
        val paymentService = PaymentService()
        val monitor = BookingMonitor(repo, bookingService, paymentService)

        monitor.loadMovies()

        monitor.processBookingEvents()

        assertEquals(3, monitor.state.value.processedBookings.size)
    }

    @Test
    fun `rejected events are tracked`() = runBlocking {
        val repo = CinemaRepository()
        val bookingService = BookingService()
        val paymentService = PaymentService()
        val monitor = BookingMonitor(repo, bookingService, paymentService)

        monitor.loadMovies()

        monitor.processBookingEvents()

        assertEquals(2, monitor.state.value.rejectedEvents.size)
    }

    @Test
    fun `total revenue increases after paid bookings`() = runBlocking {
        val repo = CinemaRepository()
        val bookingService = BookingService()
        val paymentService = PaymentService()
        val monitor = BookingMonitor(repo, bookingService, paymentService)

        monitor.loadMovies()

        monitor.processBookingEvents()

        assertEquals(7400.0, monitor.state.value.totalRevenue)
    }
}