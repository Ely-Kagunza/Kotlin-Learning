package org.example.finalproject.cinetrack.repository

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.finalproject.cinetrack.models.Customer
import org.example.finalproject.cinetrack.models.Movie
import org.example.finalproject.cinetrack.models.MovieCategory
import org.example.finalproject.cinetrack.monitor.BookingEvent

class CinemaRepository {
    suspend fun fetchMovies(): List<Movie> {
        delay(1000)
        return listOf(
            Movie("MV-1", "Bad Lands", MovieCategory.SCIFI, 40, 500.0, 10),
            Movie("MV-2", "Cops", MovieCategory.DRAMA, 45, 600.0, 8),
            Movie("MV-3", "Agent", MovieCategory.ACTION, 30, 400.0, 9),
            Movie("MV-4", "Target", MovieCategory.ANIMATION, 20, 700.0, 5)
        )
    }

    private val customers = listOf(
        Customer(id = "CT-1", name = "Alice", email = "alice@gmail.com", loyaltyPoints = 120),
        Customer(id = "CT-2", name = "Bob", email = "bob@gmail.com", loyaltyPoints = 40),
        Customer(id = "CT-3", name = "Charlie", email = "charlie@gmail.com", loyaltyPoints = 300)
    )
    suspend fun fetchCustomer(customerId: String): Customer? {
        delay(500)
        return customers.find { customer ->
            customer.id == customerId
        }
    }

    suspend fun bookingEvents(): Flow<BookingEvent> = flow {
        emit(BookingEvent("EVT-1", "CT-1", "MV-1", 4))
        delay(500)
        emit(BookingEvent("EVT-2", "CT-2", "MV-2", 5))
        delay(500)
        emit(BookingEvent("EVT-3", "CT-3", "MV-3", 6))
        delay(500)
        emit(BookingEvent("EVT-4", "CT-4", "MV-4", 7))
        delay(500)
        emit(BookingEvent("EVT-5", "CT-5", "MV-5", 8))
    }
}