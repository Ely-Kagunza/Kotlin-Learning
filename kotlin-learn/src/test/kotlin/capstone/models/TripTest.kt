package org.example.capstone.models

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TripTest {
    @Test
    fun `new trip starts in requested state`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        assertEquals(TripStatus.REQUESTED, trip.status)
        assertEquals(null, trip.driver)
        assertEquals(0.0, trip.distance)
        assertEquals(0.0, trip.fare)
    }

    @Test
    fun `assign driver moves status to matched`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = EconomyDriver("D-1", "James", 4.5)

        val driverFound = trip.assignDriver(driver)

        assertEquals(driver, driverFound)
        assertEquals(driver, trip.driver)
        assertEquals(TripStatus.MATCHED, trip.status)
    }

    @Test
    fun `cannot start before assigning driver`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = EconomyDriver("D-1", "James", 4.5)

        // trip.assignDriver(driver)

        assertFailsWith<IllegalStateException> {
            trip.startTrip()
        }
    }

    @Test
    fun `full lifecycle works`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = EconomyDriver("D-1", "James", 4.5)

        val driverFound = trip.assignDriver(driver)
        assertEquals(driverFound, driver)
        assertEquals(TripStatus.MATCHED, trip.status)

        trip.startTrip()
        assertEquals(TripStatus.IN_PROGRESS, trip.status)

//        assertFailsWith<IllegalArgumentException> {
//            trip.updateDistance(-5.0)
//        }
        trip.updateDistance(5.0)
        assertEquals(5.0, trip.distance)

        trip.completeTrip()
        assertEquals(TripStatus.COMPLETED, trip.status)
    }

    @Test
    fun `negative distance fails`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        assertFailsWith<IllegalArgumentException> {
            trip.updateDistance(-5.0)
        }
    }

    @Test
    fun `economy fare calculation`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = EconomyDriver("D-1", "James", 4.5)

        trip.assignDriver(driver)

        trip.startTrip()

        trip.updateDistance(5.0)

        trip.completeTrip()

        trip.calculateFare()

        assertEquals(250.0, trip.fare)
    }

    @Test
    fun `Premium fare calculation`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = PremiumDriver("D-1", "James", 4.5, "Lexus")

        trip.assignDriver(driver)

        trip.startTrip()

        trip.updateDistance(20.0)

        trip.completeTrip()

        trip.calculateFare()

        assertEquals(2000.0, trip.fare)
    }

    @Test
    fun `Luxury fare calculation`() {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = LuxuryDriver("D-1", "James", 4.5, true)

        trip.assignDriver(driver)

        trip.startTrip()

        trip.updateDistance(12.5)

        trip.completeTrip()

        trip.calculateFare()

        assertEquals(2500.0, trip.fare)
    }
}