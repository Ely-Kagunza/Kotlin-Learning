package org.example.capstone.services

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking
import org.example.capstone.models.EconomyDriver
import org.example.capstone.models.Passenger
import org.example.capstone.models.PaymentFailed
import org.example.capstone.models.PaymentMethod
import org.example.capstone.models.PaymentSuccess
import org.example.capstone.models.Trip

class PaymentServiceTest {
    @Test
    fun `invalid fare returns paymentFailed`() = runBlocking {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val result = PaymentService.processPayment(trip, PaymentMethod.CASH)

        assertTrue(result is PaymentFailed)
        assertEquals("Invalid fare amount", result.reason)
    }

    @Test
    fun `not completed trip returns paymentFailed`() = runBlocking {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = EconomyDriver("D-1", "James", 4.5)

        trip.assignDriver(driver)

        trip.updateDistance(5.0)

        trip.calculateFare()

        val result = PaymentService.processPayment(trip, PaymentMethod.CASH)

        assertTrue(result is PaymentFailed)
        assertEquals("Trip not completed", result.reason)
    }

    @Test
    fun `completed trip returns paymentSuccess`() = runBlocking {
        val trip = Trip("TRIP-TEST", Passenger(1, "Alice", "0700"), "A", "B")

        val driver = EconomyDriver("D-1", "James", 4.5)

        trip.assignDriver(driver)

        trip.startTrip()

        trip.updateDistance(5.0)

        trip.completeTrip()

        trip.calculateFare()

        val result = PaymentService.processPayment(trip, PaymentMethod.CASH)
        val success = result as PaymentSuccess

        assertEquals(250.0, success.amount)
        assertTrue(success.transactionId.startsWith("TXN-"))
    }
}