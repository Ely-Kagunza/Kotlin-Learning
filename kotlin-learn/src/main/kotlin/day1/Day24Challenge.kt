package org.example.day1

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun fetchMoviesSafe(): List<String> {
    delay(1000)
    return listOf("Dune", "Tenet", "Inception")
}

suspend fun fetchBookingsBroken(): Int {
    delay(500)
    throw RuntimeException("Bookings service failed")
}

suspend fun fetchRevenueSafe(): Double {
    try {
        delay(2000)
        return 125000.0
    } finally {
        println("Revenue fetch cleanup executed")
    }
}

suspend fun loadDashboardWithFailure(): String = coroutineScope {
    val fetchMovies = async { fetchMoviesSafe() }
    val fetchBookings = async { fetchBookingsBroken() }
    val fetchRevenue = async { fetchRevenueSafe() }

    val movies = fetchMovies.await()
    val bookings = fetchBookings.await()
    val revenue = fetchRevenue.await()

    "Movies: $movies\n, Bookings: $bookings\n, Revenue: $revenue"
}

fun main(): Unit = runBlocking {
    val result = runCatching {
        loadDashboardWithFailure()
    }

    result
        .onSuccess { println(it) }
        .onFailure { println("Dashboard failed: ${it.message}")}

    val job = launch {
        try {
            repeat(10) { index ->
                delay(300)
                println("Refreshing dashboard... $index")
            }
        } finally {
            println("Refresh job cleanup executed")
        }
    }

    delay(1000)
    job.cancel()
    job.join()
}