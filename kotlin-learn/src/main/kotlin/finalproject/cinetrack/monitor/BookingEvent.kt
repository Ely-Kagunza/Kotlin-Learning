package org.example.finalproject.cinetrack.monitor

data class BookingEvent(
    val eventId: String,
    val customerId: String,
    val movieId: String,
    val seatsRequested: Int
) {
    val custId: String
        get() = customerId

}