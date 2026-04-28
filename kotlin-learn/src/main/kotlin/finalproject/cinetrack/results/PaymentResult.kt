package org.example.finalproject.cinetrack.results

sealed class PaymentResult {
    data class Success(val transactionId: String, val amount: Double) : PaymentResult()
    data class Failed(val reason: String) : PaymentResult()
    data object Processing : PaymentResult()
}