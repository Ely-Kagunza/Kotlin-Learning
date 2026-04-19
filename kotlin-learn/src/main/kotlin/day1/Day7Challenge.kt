package org.example.day1

import kotlinx.coroutines.*

// TODO 1: Create 3 suspend functions
suspend fun fetchMenuItems(): List<String> {
    delay(2000)
    return listOf("pizza", "burger", "salad")
}

suspend fun fetchCustomerInfo(): Map<String, String> {
    delay(1500)
    return mapOf(
        "C1" to "Elly",
        "C2" to "Squish",
        "C3" to "Felly",
    )
}

suspend fun processOrder(): Boolean {
    delay(2500)
    return true
}

// TODO 2: In main with runBlocking
fun main() = runBlocking {
    // Run all 3 sequentially
    val startTime = System.currentTimeMillis()

    val menuItems = fetchMenuItems()
    val customerInfo = fetchCustomerInfo()
    val orderProcessed = processOrder()

    val stopTime = System.currentTimeMillis()
    val seqDiff = stopTime - startTime
    println("The time taken to run all 3 functions sequentially is ${seqDiff}ms")

    // Run all 3 concurrently
    val start = System.currentTimeMillis()

    val items = async { fetchMenuItems() }
    val info = async { fetchCustomerInfo() }
    val processed = async { processOrder() }

    val allMenuItems = items.await()
    val allCustomerInfo = info.await()
    val allProcessedOrders = processed.await()

    val stop = System.currentTimeMillis()
    val conDiff = stop - start
    println("The time taken to run all 3 functions concurrently is ${conDiff}ms\n")

    println("You save ${seqDiff - conDiff}ms if you run the functions concurrently")
}