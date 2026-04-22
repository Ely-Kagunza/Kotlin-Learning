package org.example.capstone.models

import org.example.capstone.utils.formatCurrency

enum class TripStatus(val description: String) {
    REQUESTED("Trip Requested"),
    MATCHED("Driver matched"),
    IN_PROGRESS("Trip in progress"),
    COMPLETED("Trip completed"),
    CANCELED("Trip canceled"),
}

interface Billable {
    fun calculateFare(): Double
    fun printReceipt()
}

class Trip (
    val tripId: String,
    val passenger: Passenger,
    val startLocation: String,
    val endLocation: String,
): Billable {
    var driver: Driver? = null
    private var _status: TripStatus = TripStatus.REQUESTED

    private var _distance: Double = 0.0
    private var _fare: Double = 0.0

    val distance: Double
        get() = _distance

    val fare: Double
        get() = _fare

    val status: TripStatus
        get() = _status

    fun assignDriver(driver: Driver): Driver {
        check(_status == TripStatus.REQUESTED) { "Cannot assign driver in state $_status" }
        this.driver = driver
        _status = TripStatus.MATCHED
        return driver
    }

    fun startTrip(): String {
        check(_status == TripStatus.MATCHED) { "Cannot start trip in state $_status" }
        _status = TripStatus.IN_PROGRESS
        return "Trip from $startLocation to $endLocation has started"
    }

    fun completeTrip(): String {
        check(_status == TripStatus.IN_PROGRESS) { "Cannot complete trip in state $_status" }
        _status = TripStatus.COMPLETED
        return "Trip completed"
    }

    fun cancelTrip(): String {
        _status = TripStatus.CANCELED
        return "Trip canceled"
    }

    fun updateDistance(km: Double): Double {
        require(km > 0) { "Distance must be positive, got $km" }
        _distance = km
        return _distance
    }

    override fun calculateFare(): Double {
        val currentDriver = driver ?: return 0.0

        val ratePerKm = when (currentDriver) {
            is EconomyDriver -> 50.0
            is PremiumDriver -> 100.0
            is LuxuryDriver -> 200.0
            else -> 0.0
        }

        val fare = ratePerKm * _distance
        _fare = fare
        return fare
    }

    override fun printReceipt() {
        println("==== Ride Receipt ====")
        println("Driver: ${driver?.name}")
        println("Passenger: ${passenger.name}")
        println("Distance: $_distance")
        println("Total price: ${formatCurrency(fare)}\n")
    }

    companion object {
        var nextTripId: Int = 1
            private set

        fun createTrip(
            pass: Passenger,
            startLocation: String,
            endLocation: String,
        ): Trip {
            val id = "TRIP-${nextTripId++}"
            return Trip(id, pass, startLocation, endLocation)
        }

    }
}