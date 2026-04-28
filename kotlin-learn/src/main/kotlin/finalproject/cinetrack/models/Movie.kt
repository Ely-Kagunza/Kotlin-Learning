package org.example.finalproject.cinetrack.models

data class Movie (
    val id: String,
    val title: String,
    val category: MovieCategory,
    val durationMinutes: Int,
    val ticketPrice: Double,
    val availableSeats: Int
) {
    init {
        require(id.isNotBlank()) { "id must not be blank" }
        require(title.isNotBlank()) { "title must not be blank" }
        require(durationMinutes > 0) { "duration must not be greater than zero" }
        require(ticketPrice > 0) { "ticketPrice must be greater than zero" }
        require(availableSeats >= 0) { "availableSeats must higher than 0" }
    }

    fun isSoldOut(): Boolean {
        return availableSeats == 0
    }
}