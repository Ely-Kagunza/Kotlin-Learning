package org.example.finalproject.cinetrack.models

class Booking(
    val bookingId: String,
    val customer: Customer,
    val movie: Movie,
    val seatsRequested: Int
) {
    private var _status: BookingStatus = BookingStatus.PENDING
    private var _paymentStatus: PaymentStatus = PaymentStatus.UNPAID
    private var _totalAmount: Double = 0.0

    val status: BookingStatus
        get() = _status

    val paymentStatus: PaymentStatus
        get() = _paymentStatus

    val totalAmount: Double
        get() = _totalAmount

    fun confirm(): BookingStatus {
        check(status == BookingStatus.PENDING) { "status must be in 'PENDING'" }
        _status = BookingStatus.CONFIRMED
        return status
    }

    fun reject() {
        check(status == BookingStatus.PENDING) { "status must be in 'PENDING'" }
        _status = BookingStatus.REJECTED
    }

    fun cancel() {
        check(status == BookingStatus.CONFIRMED || status == BookingStatus.PENDING) { "status must be in 'PENDING' or 'CONFIRMED'" }
        _status = BookingStatus.CANCELLED
    }

    fun markPaid(): PaymentStatus {
        check(status == BookingStatus.CONFIRMED) { "status must be in 'PENDING'" }
        _paymentStatus = PaymentStatus.PAID
        return paymentStatus
    }

    fun calculateTotal(): Double {
        require(seatsRequested > 0) { "Seats Requested must be positive." }
        _totalAmount = seatsRequested * movie.ticketPrice
        return totalAmount
    }

    companion object {
        var totalBookings: Int = 0
            private set

        fun create(customer: Customer, movie: Movie, seatsRequested: Int): Booking {
            val booking = Booking("BK-${++totalBookings}", customer, movie, seatsRequested)
            booking._status = BookingStatus.PENDING
            return booking
        }
    }
}