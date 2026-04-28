package org.example.finalproject.cinetrack.models

data class Customer(
    val id: String,
    val name: String,
    val email: String?,
    val loyaltyPoints: Int,
) {
    init {
        require(id.isNotBlank()) { "Id cannot be blank" }
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(loyaltyPoints >= 0) { "Loyalty points cannot be negative" }
    }
}