package org.example.day1

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

fun fetchNamesBlocking(): List<String> {
    Thread.sleep(2000)
    return listOf("Finch", "Harold", "Asylum")
}

suspend fun addNumberWithDelay(a: Int, b: Int): Int {
    delay(2000)
    return a + b
}

fun main() = runBlocking {
    println("--- Calling 3 suspend functions sequentially ---")
    val start = System.currentTimeMillis()
    val one = addNumberWithDelay(10, 10)
    val two = addNumberWithDelay(20, 20)
    val three = addNumberWithDelay(30, 30)
    val stop = System.currentTimeMillis()

    val timeTakenDelay = stop - start
    println("results $one, $two, $three, it took ${timeTakenDelay}ms")

    val startTime = System.currentTimeMillis()
    println(fetchNamesBlocking())
    println(fetchNamesBlocking())
    println(fetchNamesBlocking())
    val endTime = System.currentTimeMillis()

    val timeTakenThread = endTime - startTime

    println("difference between delay and Thread.sleep is ${timeTakenDelay - timeTakenThread}ms")
}