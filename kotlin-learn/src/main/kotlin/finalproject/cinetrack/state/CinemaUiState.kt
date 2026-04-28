package org.example.finalproject.cinetrack.state

import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.Movie
import org.example.finalproject.cinetrack.monitor.BookingEvent

data class CinemaUiState(
    val loading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val processedBookings: List<Booking> = emptyList(),
    val rejectedEvents: List<BookingEvent> = emptyList(),
    val totalRevenue: Double = 0.0,
    val error: String? = null
)