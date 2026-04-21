package org.example.capstone.services

import org.example.capstone.models.PaymentResult
import org.example.capstone.models.Trip
import org.example.capstone.models.TripStatus
import org.example.capstone.models.PaymentMethod
import kotlinx.coroutines.*
import org.example.capstone.models.PaymentFailed
import org.example.capstone.models.PaymentSuccess

object PaymentService {
    suspend fun processPayment(trip: Trip, method: PaymentMethod): PaymentResult {
        delay(2000)
        return when {
            trip.fare <= 0 -> PaymentFailed("Invalid fare amount")
            trip.status != TripStatus.COMPLETED -> PaymentFailed("Trip not completed")
            else -> PaymentSuccess("TXN-${java.util.UUID.randomUUID()}", trip.fare)
        }
    }
}