package org.example.day1

val pizzaPrice = 500.0
val burgerPrice = 450.0
val saladPrice = 200.0

// TODO 1: Write a function that calculates menu item cost
fun calculateItemCost(itemName: String, quantity: Int = 1): Double {
    return when (itemName.lowercase()) {
        "pizza" -> pizzaPrice * quantity
        "burger" -> burgerPrice * quantity
        "salad" -> saladPrice * quantity
        else -> 0.0
    }
}

// TODO 2: Write a function that applies a discount
fun applyDiscount(originalPrice: Double, discountPercentage: Double): Double {
    val discountPrice: Double = originalPrice * (discountPercentage / 100.0)
    return originalPrice - discountPrice
}

// TODO 3: Write a higher order function that processes multiple orders
fun processOrders(items: List<String>, transformer: (Double) -> Double): Double {
    var totalPrice = 0.0

    items.forEach { item ->
        val cost = calculateItemCost(item)
        totalPrice += cost
    }
    return transformer(totalPrice)
}

fun main() {

    println("--- Menu Price ---")
    println("Pizza: $pizzaPrice")
    println("Burger: $burgerPrice")
    println("Salad: $saladPrice\n")

    // TODO 4: Calculate cost for 2 pizzas, apply 15% discount, print the result\
    val itemCost = calculateItemCost("Pizza", 2)
    println("Item Cost: KSh ${"%.2f".format(itemCost)}")
    val afterDiscount = applyDiscount(itemCost, 15.0)
    println("After 15% discount: KSh ${"%.2f".format(afterDiscount)}\n")

    // TODO 5: Use processOrders with a lambda that applies 20% discount
    val menuItems = listOf<String>("pizza", "burger", "salad")
    val processedPrice = processOrders(menuItems) {total -> total * 0.8}
    println("All items total: KSh ${"%.2f".format(menuItems.sumOf { calculateItemCost(it)})}")
    println("With 20% discount: KSh ${"%.2f".format(processedPrice)}\n")

    // TODO 6: Create a lamda that doubles the price (for markup)
    val doublePrice = processOrders(menuItems) { total -> total * 2}
    println("All items doubled: KSh ${"%.2f".format(doublePrice)}\n")
}