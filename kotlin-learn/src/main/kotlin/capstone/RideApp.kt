package org.example.capstone


import kotlinx.coroutines.*
import org.example.capstone.models.Passenger
import org.example.capstone.models.Driver
import org.example.capstone.models.PaymentMethod
import org.example.capstone.models.Trip
import org.example.capstone.services.findAvailableDriver
import org.example.capstone.services.TripService
import org.example.capstone.services.PaymentService
import org.example.capstone.services.PaymentService.processPayment
import org.example.capstone.services.applyDiscountToTrips
import org.example.capstone.services.getCompletedTrips
import org.example.capstone.services.getTotalRevenue
import org.example.capstone.utils.formatCurrency

fun tripSummary(passenger: Passenger, amount: Double): String {
    return "Thank you ${passenger.name} for riding with us. Your fare is ${formatCurrency(amount)}\n"
}

fun averageFare(): Double {
    val completed = getCompletedTrips()
    return if (completed.isEmpty()) 0.0 else completed.sumOf { it.fare } / completed.size
//    val avg = getTotalRevenue() / TripService.totalTripsCompleted
//    return avg
}

fun main() = runBlocking {
    AppConfig.printInfo()

    val passOne = Passenger().apply {
        id = 101
        name = "Alice"
        phone = "0758446841"
        email = "alice@gmail.com"
    }

    val passTwo = Passenger().apply {
        id = 102
        name = "Bob"
        phone = "0758446842"
    }

    val passThree = Passenger().apply {
        id = 103
        name = "Charlie"
        phone = "0758446843"
        email = "cha@gmail.com"
    }

//    val economy = EconomyDriver().apply {
//        driverId = "DRI-101"
//        name = "Alice"
//        rating = 4.4
//    }
//
//    val premium = PremiumDriver().apply {
//        driverId = "DRI-102"
//        name = "Charlie"
//        rating = 4.6
//        luxuryCarModel = "Lexus"
//    }
//
//    val luxury = LuxuryDriver().apply {
//        driverId = "DRI-103"
//        name = "Bob"
//        rating = 4.7
//        includesChauffeur = true
//    }
    // println("Passenger: $passOne\n")
    // println("luxury: ${luxury}\n")

    val tripOne = Trip.createTrip(passOne, "Bangu", endLocation = "Kite")
    val tripTwo = Trip.createTrip(passTwo, "Huruma", endLocation = "Allsops")
    val tripThree = Trip.createTrip(passThree, "Dony", endLocation = "Tao")

    val start = System.currentTimeMillis()
    val trip1Driver = async { findAvailableDriver("economy")}
    val trip2Driver = async { findAvailableDriver("luxury")}
    val trip3Driver = async { findAvailableDriver("premium")}

    val driverOne: Driver? = trip1Driver.await()
    val driverTwo: Driver? = trip2Driver.await()
    val driverThree: Driver? = trip3Driver.await()
    val stop = System.currentTimeMillis()
    println("Time taken to get drivers: ${stop - start}ms\n")

    // tripOne.startLocation.let { it.assignDriver(driverOne) }
    // driverOne?.let { driver -> Trip.assignDriver(driver) }
    driverOne?.let { driver -> tripOne.assignDriver(driver) }
    // println("$t1")
    driverTwo?.let { driver -> tripTwo.assignDriver(driver)}
    driverThree?.let { driver -> tripThree.assignDriver(driver)}

    tripOne.startTrip()
    tripTwo.startTrip()
    tripThree.startTrip()

    val trips = listOf(tripOne, tripTwo, tripThree)

    tripOne.updateDistance(5.0)
    tripTwo.updateDistance(12.5)
    tripThree.updateDistance(20.0)

    trips.forEach { trip ->
        trip.completeTrip()
        trip.calculateFare()
        val summary = tripSummary(trip.passenger, trip.fare)
        println(summary)
    }

    val p1 = async { PaymentService.processPayment(tripOne, PaymentMethod.MOBILE_MONEY) }
    val p2 = async { PaymentService.processPayment(tripTwo, PaymentMethod.CASH) }
    val p3 = async { PaymentService.processPayment(tripThree, PaymentMethod.CARD) }

    val paymentOne = p1.await().also { println(it) }
    val paymentTwo = p2.await().also { println(it) }
    val paymentThree = p3.await().also { println(it) }
    println("\n")
//
//    val resultOne = paymentOne
//    when (resultOne) {
//        is PaymentResult.PaymentSuccess -> println("SUCCESS")
//        is PaymentFailed -> println("FAILED")
//        is PaymentProcessing -> println("PROCESSING")
//        else -> println("Unknown error")
//    }

    trips.forEach { trip ->
        TripService.addTrip(trip)
        trip.printReceipt()
    }

    val discounts = applyDiscountToTrips(10.0) { trip -> trip.fare > 1000}
    println("The discounts are: $discounts\n")

    println("--- Trips analytics ---")
    println("Total trips completed: ${getCompletedTrips().size}")
    println("Total revenue: ${formatCurrency(getTotalRevenue())}")
    println("Average fare: ${formatCurrency(averageFare())}\n")

     val failedTrip = Trip.createTrip(passOne, "Failed", endLocation = "Kite")
     val fp = async {processPayment(failedTrip, PaymentMethod.CASH) }
     val failedProcess = fp.await() .also { println(it) }

    val failedDistance = failedTrip.updateDistance(-0.5)
    println("Failed: $failedDistance \n")

}