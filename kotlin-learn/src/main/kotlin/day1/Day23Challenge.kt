package org.example.day1

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun fetchNowShowing(): List<String> {
    delay(2000)
    return listOf("Dune", "Inception", "Tenet")
}

suspend fun fetchTodayBookings(): Int {
    delay(1500)
    return 42
}

suspend fun fetchRevenue(): Double {
    delay(2500)
    return 125000.0
}

fun main() = runBlocking {
    val start = System.currentTimeMillis()

    val fetchShowing = fetchNowShowing()
    val fetchBookings = fetchTodayBookings()
    val fetchRevenue = fetchRevenue()

    val stop = System.currentTimeMillis()
    println("--- Sequential Dashboard Load ---")
    println("Sequential load results: Movies: $fetchShowing\nBookings:$fetchBookings\nRevenue: $fetchRevenue")
    val sequentialDiffTime = stop - start
    println("Sequential time: $sequentialDiffTime")

    val logger = launch {
        delay(5000)
        println("\nLoading dashboard data...")
    }


    val startTime = System.currentTimeMillis()

    val one = async { fetchNowShowing() }
    val two = async { fetchTodayBookings() }
    val three = async { fetchRevenue() }

    val v1 = one.await()
    val v2 = two.await()
    val v3 = three.await()

    val stopTime = System.currentTimeMillis()
    println("\n--- Concurrent Dashboard Load ---")
    println("Concurrent load results: Movies: $v1\nBookings:$v2\nRevenue: $v3")
    val concurrentDiffTime = stopTime - startTime
    println("Concurrent time: $concurrentDiffTime")

    println("\nTime saved: ${sequentialDiffTime - concurrentDiffTime}")

    logger.join()

}