package org.example.finalproject.cinetrack

import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.Customer
import org.example.finalproject.cinetrack.models.Movie
import org.example.finalproject.cinetrack.models.MovieCategory
import org.example.finalproject.cinetrack.monitor.BookingMonitor
import org.example.finalproject.cinetrack.repository.CinemaRepository
import org.example.finalproject.cinetrack.services.BookingService
import org.example.finalproject.cinetrack.services.PaymentService
import org.example.finalproject.cinetrack.utils.toKsh

fun main() = runBlocking {
    val repo = CinemaRepository()
    val bookingServices = BookingService()
    val paymentServices = PaymentService()
    val monitor = BookingMonitor(repo, bookingServices, paymentServices)

    val stateCollector = launch {
        monitor.state.collect { state ->
            println("STATE: ${state.toString()}")
        }
    }

    val eventCollector = launch {
        monitor.event.collect { event ->
            println("EVENT: $event")
        }
    }

    monitor.loadMovies()

    val processBooking = launch {
        monitor.processBookingEvents()
    }

    processBooking.join()

    stateCollector.cancel()
    eventCollector.cancel()

    println("\n--- Final Summary ---")
    println("Movies loaded: ${monitor.state.value.movies.size}")
    println("Booking processed: ${monitor.state.value.processedBookings.size}")
    println("Rejected events: ${monitor.state.value.rejectedEvents.size}")
    println("Total revenue: ${monitor.state.value.totalRevenue.toKsh()}")

}