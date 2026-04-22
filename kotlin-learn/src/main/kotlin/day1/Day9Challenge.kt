package org.example.day1

import sun.security.util.KeyUtil.validate

data class Ord(val id: String, val total: Double, val status: String)

class InvalidOrderException(message: String) : Exception(message)

val rawOrders = listOf(
    "ORD-1, 500.00, paid",
    "ORD-2, abc, paid",              // bad total
    "ORD-3, -50.00, paid",           // negative total
    "ORD-4, 1200.00, unknown",       // bad status
    "ORD-5, 2500.00, pending",       // valid but not paid
    "ORD-6, 800.00, paid",
    "ORD-7, , paid",                 // empty total
    "ORD-8, 300.00, paid"
)

val allowedStatuses = listOf("pending", "paid", "confirmed", "cancelled", "refunded")

fun parseOrderOrNull(raw: String): Ord? {
    val parts = raw.split(",").map { it.trim() }
    if (parts.size != 3) return null
    val total = parts[1].toDoubleOrNull() ?: return null
    return Ord(parts[0], total, parts[2])
}

fun validateOrder(order: Ord) {
    if (order.total <= 0) {
        throw InvalidOrderException("Total must be positive, got ${order.total}")
    }
    require(order.status in allowedStatuses) { "Invalid status: ${order.status}" }
}

fun processOrder(order: Ord): String {
    check(order.status == "paid") { "Order ${order.id} not paid, status is ${order.status}" }
    return "Order ${order.id} processed (total: KSh ${"%.2f".format(order.total)})"
}

fun main() {
    val results = mutableListOf<Boolean>()

    rawOrders.forEach { raw ->
        val order = parseOrderOrNull(raw)
        if (order == null) {
            println("$raw -> Parse failed")
            results.add(false)
            return@forEach
        }

        val result = runCatching {
            validateOrder(order)
            processOrder(order)
        }

        result
            .onSuccess { confirmation ->
                println("${order.id} -> OK: $confirmation")
                results.add(true)
            }
            .onFailure { error ->
                println("${order.id} -> FAILED: ${error.message}")
                results.add(false)
            }
    }

    println("\n--- Summary ---")
    println("Successful: ${results.filter { it }.size}")
    println("Failed: ${results.filter { !it }.size}")
}