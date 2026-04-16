package org.example.day1

fun main() {
    // TODO 1: Create a list of prices: [500, 450, 200, 300, 250]
    val prices = listOf<Double>(500.0, 450.0, 200.0, 300.0, 250.0)
    println("List of prices: $prices\n")
    // TODO 2: Filter prices over 300
    val over = prices.filter { price -> price > 300 }
    println("Prices greater than 300: $over\n")
    // TODO 3: Map them to discounted prices (10% off)
    val discounts = over.map { price -> price * 0.9}
    println("Discount of prices greater than 300: $discounts\n")
    // TODO 4: Sum the discounted total
    val discountedSum = discounts.sum()
    println("Sum of discounted prices KSh ${"%.2f".format(discountedSum)}\n")
    // TODO 5: Create a map of menu items
    val menuItems = mapOf<String, Double>(
        "pizza" to 500.0,
        "burger" to 450.0,
        "salad" to 200.0,
        "pasta" to 350.0
    )
    // TODO 6: Find the most expensive item
    val mostExpensive = menuItems.map { (_, price) -> price }.max()
    val expensive = menuItems.values.maxOrNull() ?: 0.0
    println("The most expensive item in the menu is priced at KSh ${"%.2f".format(expensive)}\n (Same output as $mostExpensive)\n")
    // TODO 7: Find all items under 300
    val under300 = menuItems.filter { (_, price) -> price < 300 }
    println("Under price 300 items in the menu is $under300\n")
    /* TODO 8: Calculate average price */
    val averagePrice = menuItems.map { (_, price) -> price }.average()
    println("Average price is for the menuItems is: KSh ${"%.2f".format(averagePrice)}\n")
    // TODO 9: Create a set of order IDs (test with duplicates)
    val orderIds = setOf<String>("ID-1", "ID-2", "ID-3", "ID-4", "ID-5", "ID-5")
    println("OrderIds: $orderIds\n")
}