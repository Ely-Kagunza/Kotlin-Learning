package org.example.capstone.models

sealed class PaymentResult

data class PaymentSuccess(val transactionId: String, val amount: Double) : PaymentResult()
data class PaymentFailed(val reason: String) : PaymentResult()
object PaymentProcessing : PaymentResult()

enum class PaymentMethod { CASH, CARD, MOBILE_MONEY }
