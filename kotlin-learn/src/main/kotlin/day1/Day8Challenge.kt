package org.example.day1

data class TodayOrders(
    val orderId: String,
    val total: Double,
    val hour: Int,          // 0..23
    val status: String      // "pending", "paid", "cancelled", "refunded"
)

val orders = listOf(
    TodayOrders("ORD-1", 0.0, 14, "pending"),
    TodayOrders("ORD-2", 850.0, 12, "paid"),
    TodayOrders("ORD-3", 2500.0, 22, "paid"),
    TodayOrders("ORD-4", 450.0, 3, "paid"),
    TodayOrders("ORD-5", 1200.0, 19, "confirmed"),
    TodayOrders("ORD-6", 600.0, 9, "cancelled"),
    TodayOrders("ORD-7", 5500.0, 13, "paid"),
    TodayOrders("ORD-8", 350.0, 23, "refunded")
)

val validStatuses = listOf("pending", "paid", "cancelled", "refunded", "confirmed")
val reject = listOf("cancelled", "refunded")

fun classifyOrder(order: TodayOrders): String {
    return when {
        order.total <= 0 -> "Invalid order"
        order.status !in validStatuses -> "Invalid status"
        order.status in reject -> "Rejected"
        else -> "${timeOfDay(order.hour)}${priorityTag(order.total)}"
    }
}

fun timeOfDay(hour: Int): String = when (hour) {
    in 6..10 -> "Breakfast"
    in 11..14 -> "Lunch"
    in 17..21 -> "Dinner"
    in 22..23, in 0..5 -> "Late night"
    else -> "Off-Peak"
}

fun priorityTag(total: Double): String = when {
    total >= 2000 -> " (VIP)"
    total in 1000.0..1999.99 -> " (High)"
    total in 500.0..999.99 -> " (Medium)"
    else -> " (Low)"
}

fun main() {
    orders.forEachIndexed { index, order ->
        println("$index: ${order.orderId} -> ${classifyOrder(order)}")
    }

    for (i in 23 downTo 0 step 4) {
        println("Hour $i: ${timeOfDay(i)}")
    }

    println("\n--- Classification counts ---")
    val classifications = orders.map { classifyOrder(it) }.distinct()
    classifications.forEach { tag ->
        val count = orders.count { classifyOrder(it) == tag }
        println("$tag: $count")
    }
}