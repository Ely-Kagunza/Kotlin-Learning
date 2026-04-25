package org.example.day1

fun currencyFormat(amount: Double): String {
    return "KSh ${"%.2f".format(amount)}"
}

abstract class Delivery(
    val trackingId: String,
    val distanceKm: Double
) {
    init {
        require(trackingId.isNotBlank()) { "TrackingId must not be empty" }
        require(distanceKm > 0) { "Distance must be positive" }
    }

    fun calculateTotalCost(): Double {
        return baseFee() + distanceCost()
    }

    protected fun distanceCost(): Double {
        return distanceKm * ratePerKm()
    }

    protected abstract fun baseFee(): Double
    protected abstract fun ratePerKm(): Double

    abstract fun description(): String
}

class BikeDelivery(trackingId: String, distance: Double) : Delivery(trackingId, distance) {
    override fun baseFee(): Double = 50.0
    override fun ratePerKm(): Double = 20.0

    override fun description(): String {
        return "Bike delivery $trackingId: ${distanceKm}km, total ${currencyFormat(calculateTotalCost())}"
    }
}

class VanDelivery(trackingId: String, distance: Double) : Delivery(trackingId, distance) {
    override fun baseFee(): Double = 200.0
    override fun ratePerKm(): Double = 80.0

    override fun description(): String {
        return "Van delivery $trackingId: ${distanceKm}km, total ${currencyFormat(calculateTotalCost())}"
    }
}

class DroneDelivery(trackingId: String, distance: Double) : Delivery(trackingId, distance) {
    override fun baseFee(): Double = 500.0
    override fun ratePerKm(): Double = 120.0

    override fun description(): String {
        return "Drone delivery $trackingId: ${distanceKm}km, total ${currencyFormat(calculateTotalCost())}"
    }
}

fun main() {
    val deliveries = listOf(
        BikeDelivery(trackingId = "Bike-100", distance = 5.0),
        VanDelivery(trackingId = "Van-100", distance = 5.0),
        DroneDelivery(trackingId = "Drone-100", distance = 5.0)
    )
    deliveries.forEach { delivery ->
        println(delivery.description())
    }
}