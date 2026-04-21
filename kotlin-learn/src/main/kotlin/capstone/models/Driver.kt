package org.example.capstone.models

open class Driver(val driverId: String, val name: String, var rating: Double) {
    open fun description(): String {
        return "Driver $name, ID: $driverId has rating: $rating"
    }
}

class EconomyDriver(driverId: String, name: String, rating: Double) : Driver(driverId, name, rating) {
    override fun description(): String {
        return "${super.description()} - (Economy Class)"
    }
}

class PremiumDriver(driverId: String, name: String, rating: Double, var carModel: String) : Driver(driverId, name, rating) {
    override fun description(): String {
        return "${super.description()} - (Premium Class) - $carModel"
    }
}

class LuxuryDriver(driverId: String, name: String, rating: Double, var includesChauffeur: Boolean) : Driver(driverId, name, rating) {
    override fun description(): String {
        return "${super.description()} - (Luxury Car) - $includesChauffeur"
    }
}