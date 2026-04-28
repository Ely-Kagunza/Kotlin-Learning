package org.example.finalproject.cinetrack.services

import org.example.finalproject.cinetrack.models.Booking
import org.example.finalproject.cinetrack.models.Customer
import org.example.finalproject.cinetrack.models.Movie
import org.example.finalproject.cinetrack.results.BookingResult
import org.example.finalproject.cinetrack.utils.isValidEmail


class BookingService {
    fun processBooking(customer: Customer, movie: Movie, seatsRequested: Int): BookingResult {
        return when {
            customer.email.isNullOrBlank() || !customer.email.isValidEmail() -> {
                BookingResult.InvalidCustomer("Invalid email")
            }

            seatsRequested > movie.availableSeats -> {
                BookingResult.NotEnoughSeats(movie.id, seatsRequested, movie.availableSeats)
            }

            else -> {
                val booking = Booking.create(customer, movie, seatsRequested)
                booking.calculateTotal()
                booking.confirm()
                BookingResult.Success(booking)
            }
        }
    }
}