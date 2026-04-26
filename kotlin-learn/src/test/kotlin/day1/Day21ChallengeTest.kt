package org.example.day1

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class Day21ChallengeTest {
    @Test
    fun `new booking starts pending`() {
        val booking = CinemaBooking(
            "B_101",
            "Elly",
            "Person Of Interest",
            5,
            10
        )

        assertEquals(BookingStatus.PENDING, booking.status)
        assertEquals(5, booking.requestedSeats)
        assertEquals(10, booking.availableSeats)
    }

    @Test
    fun `Invalid blank booking ID fails`() {
        assertFailsWith<IllegalArgumentException> {
            CinemaBooking(
                "",
                "Elly",
                "Person Of Interest",
                5,
                10
            )
        }
    }

    @Test
    fun `Invalid requested seats fails`() {
        assertFailsWith<IllegalArgumentException> {
            CinemaBooking(
                "B_101",
                "Elly",
                "Person Of Interest",
                0,
                10
            )
        }
    }

    @Test
    fun `Successful booking returns success`() {
        val booking = CinemaBooking(
            "B_101",
            "Elly",
            "Person Of Interest",
            2,
            10
        )

        val result = CinemaBookingService.processBooking(booking)
        assertTrue(result is BookingResult.BookingSuccess)
        assertEquals("B_101", result.bookingId)
        assertEquals("Person Of Interest", result.movieTitle)
        assertEquals(2, result.seatsBooked)
        assertEquals(BookingStatus.CONFIRMED, booking.status)
    }

    @Test
    fun `Not enough seats returns NotEnoughSeats`() {
        val booking = CinemaBooking(
            "B_101",
            "Elly",
            "Person Of Interest",
            8,
            3
        )
        val result = CinemaBookingService.processBooking(booking)
        assertTrue(result is BookingResult.NotEnoughSeats)
        assertEquals(BookingStatus.PENDING, booking.status)

        val failed = result as BookingResult.NotEnoughSeats
        assertEquals(8, failed.requestedSeats)
        assertEquals(3, failed.availableSeats)
    }

    @Test
    fun `cancelled booking returns alreadyFinalized`() {
        val booking = CinemaBooking(
            "B_101",
            "Elly",
            "Person Of Interest",
            8,
            3
        )
        booking.cancel()
        val result = CinemaBookingService.processBooking(booking)
        assertTrue(result is BookingResult.AlreadyFinalized)
        assertEquals(BookingStatus.CANCELLED, booking.status)

        val finalized = result as BookingResult.AlreadyFinalized
        assertEquals("B_101", finalized.bookingId)
        assertEquals(BookingStatus.CANCELLED, finalized.currentStatus)
    }

    @Test
    fun `cannot cancel twice`() {
        val booking = CinemaBooking(
            "B_101",
            "Elly",
            "Person Of Interest",
            8,
            3
        )
        booking.cancel()
        assertFailsWith<IllegalStateException> {
            booking.cancel()
        }
    }

    @Test
    fun `cannot confirm twice`() {
        val booking = CinemaBooking(
            "B_101",
            "Elly",
            "Person Of Interest",
            8,
            3
        )
        booking.confirm()
        assertFailsWith<IllegalStateException> {
            booking.confirm()
        }
    }
}