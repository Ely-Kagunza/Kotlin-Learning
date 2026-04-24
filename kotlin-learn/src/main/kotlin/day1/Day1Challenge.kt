package org.example.day1

fun main() {
    println("========= RESTAURANT ORDER SYSTEM =========\n")

    // ===== PART 1: Immutability =====
    val pizzaPrice: Double = 500.0
    val burgerPrice: Double = 450.0
    val saladPrice: Double = 200.0

    // Menu display
    println("--- MENU ---")
    println("Pizza: KSh $pizzaPrice")
    println("Burger: KSh $burgerPrice")
    println("Salad: KSh $saladPrice\n")

    // ===== PART 2: Type Safety =====
    val discountPercentage: Double = 10.0  // Use Double for calculations
    val discountName: String = "Loyalty Discount"
    println("Applied: $discountName ($discountPercentage%)\n")

    // ===== PART 3: Null Safety =====
    val customerName: String = "Elly"
    val customerPhone: String? = null  // Can be null
    val orderNumber: Int? = null

    // Safe access with Elvis operator
    val displayPhone = customerPhone ?: "No phone provided"
    val displayOrder = orderNumber ?: "Not assigned"

    println("--- CUSTOMER INFO ---")
    println("Name: $customerName")
    println("Phone: $displayPhone")
    println("Order #: $displayOrder\n")

    // ===== PART 4: String Templates =====
    val itemOrdered = "pizza"
    val quantity = 2

    // ===== PART 5: `when` Expression =====
    val unitPrice = when (itemOrdered.lowercase()) {
        "pizza" -> pizzaPrice
        "burger" -> burgerPrice
        "salad" -> saladPrice
        else -> 0.0
    }

    val subtotal = unitPrice * quantity
    val discountAmount = subtotal * (discountPercentage / 100)
    val finalTotal = subtotal - discountAmount

    // ===== RECEIPT =====
    println("========= RECEIPT =========")
    println("Item: ${itemOrdered.uppercase()}")
    println("Quantity: $quantity")
    println("Unit Price: KSh ${"%.2f".format(unitPrice)}")
    println("Subtotal: KSh ${"%.2f".format(subtotal)}")
    println("Discount ($discountPercentage%): -KSh ${"%.2f".format(discountAmount)}")
    println("FINAL TOTAL: KSh ${"%.2f".format(finalTotal)}")
    println("===========================")
}