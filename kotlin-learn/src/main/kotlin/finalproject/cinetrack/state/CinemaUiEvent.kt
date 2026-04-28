package org.example.finalproject.cinetrack.state

sealed class CinemaUiEvent {
    data class BookingConfirmed(val message: String) : CinemaUiEvent()
    data class BookingRejected(val reason: String) : CinemaUiEvent()
    data class PaymentCompleted(val message: String) : CinemaUiEvent()
    data class Error(val message: String) : CinemaUiEvent()
}