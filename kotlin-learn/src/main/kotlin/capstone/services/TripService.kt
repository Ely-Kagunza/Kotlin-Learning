package org.example.capstone.services

import org.example.capstone.models.Trip
import org.example.capstone.models.Driver
import org.example.capstone.models.EconomyDriver
import org.example.capstone.models.LuxuryDriver
import org.example.capstone.models.PremiumDriver
import kotlinx.coroutines.*
import org.example.capstone.models.TripStatus

object TripService {
    private var _allTrips: MutableList<Trip> = mutableListOf()

    val allTrips: List<Trip>
        get() = _allTrips.toList()

    fun addTrip(trip: Trip) {
        _allTrips.add(trip)
    }
}

suspend fun findAvailableDriver(tripType: String): Driver? {
    delay(1500)

    return when (tripType.lowercase()) {
        "economy" -> EconomyDriver("D-001", "James Karanja", 4.5)
        "premium" -> PremiumDriver("D-002", "Peter Odhiambo", 4.8, "BMW 5 Series")
        "luxury" -> LuxuryDriver("D-003", "David Mwangi", 4.9, true)
        else ->  null // EconomyDriver()
    }
}

fun getCompletedTrips(): List<Trip> {
    val trips = TripService.allTrips
    return trips.filter { trip -> trip.status == TripStatus.COMPLETED }
}

fun getTotalRevenue(): Double {
    val completedTrips = getCompletedTrips()
    return completedTrips.sumOf { trip -> trip.fare}
}

fun getTripsByPassenger(passengerId: Int): List<Trip> {
    val trips = TripService.allTrips
    return trips.filter { trip -> trip.passenger.id == passengerId }
}

fun applyDiscountToTrips(discountPercentage: Double, filter: (Trip) -> Boolean): List<Double> {
    val trips = getCompletedTrips()
    val discountedTrips = trips
        .filter (filter)
        .map { trip -> trip.fare * (1 - discountPercentage / 100.0) }

    return discountedTrips
}