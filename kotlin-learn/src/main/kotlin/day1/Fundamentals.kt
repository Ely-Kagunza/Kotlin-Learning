package org.example.day1

fun main() {
    println("========== DAY 1: KOTLIN FUNDAMENTALS ==========\n")

    // ====== CONCEPT 1: Immutable vs Mutable Variables ======
    println("--- CONCEPT 1: Variables ---")

    // val = immutable (cannot change after assignment)
    val name = "Kitchen Command"
    val age: Int = 25

    // var = mutable (can change)
    var count = 0
    count = 5

    // Type inference (Kotlin figures out the type)
    val price = 19.99  // Double inferred
    val isAvailable = true  // Boolean inferred

    // Explicit types
    val revenue: Double = 5000.50
    val orderId: String = "ORD-001"

    println("Name: $name")
    println("Age: $age")
    println("Count: $count")
    println("Price: $price")
    println("Is Available: $isAvailable")
    println("Revenue: $revenue")
    println("Order ID: $orderId")
    println()

    // ====== CONCEPT 2: Null Safety (The Kotlin Superpower) ======
    println("--- CONCEPT 2: Null Safety ---")

    // Non-null type (cannot be null)
    val customerName: String = "John"
    // customerName = null  // COMPILE ERROR - Kotlin stops you before runtime

    // Nullable type (explicitly can be null)
    val phoneNumber: String? = null
    val email: String? = "john@kitchen.com"

    println("Customer: $customerName")

    // Check before using (safe)
    if (phoneNumber != null) {
        println("Phone length: ${phoneNumber.length}")
    } else {
        println("Phone: No phone provided")
    }

    // Safe call operator (?.) - returns null if phoneNumber is null
    val length = phoneNumber?.length
    println("Safe call result: $length")

    // Elvis operator (?:) - provide default if null
    val displayPhone = phoneNumber ?: "No phone number"
    println("Display Phone: $displayPhone")

    val displayEmail = email ?: "No email"
    println("Display Email: $displayEmail")
    println()

    // ====== CONCEPT 3: String Templates ======
    println("--- CONCEPT 3: String Templates ---")

    val item = "Pizza"
    val itemPrice = 12.99
    val quantity = 3

    // String template with $
    val message = "You ordered: $item"
    println(message)

    // Expression in template
    val total = itemPrice * quantity
    val receipt = "$quantity x $item = $${"%.2f".format(total)}"
    println(receipt)

    // Complex expression
    val calculation = "Price per item: $$itemPrice, Total for $quantity: $${"%.2f".format(total)}"
    println(calculation)

    // Raw string (multi-line)
    val json = """
        {
            "item": "$item",
            "price": $itemPrice,
            "quantity": $quantity,
            "total": ${"%.2f".format(total)}
        }
    """.trimIndent()
    println("JSON Output:")
    println(json)
    println()

    // ====== CHALLENGE: Build a Receipt ======
    println("--- CHALLENGE: Restaurant Order Receipt ---")

    val customerNameReceipt = "Alice"
    val pizzaPriceReceipt = 12.99
    val burgerPriceReceipt = 8.99
    val saladPriceReceipt = 6.99

    val itemOrderedReceipt = "PIZZA"
    val quantityReceipt = 2

    // Calculate total based on item
    val totalPrice = when (itemOrderedReceipt.lowercase()) {
        "pizza" -> pizzaPriceReceipt * quantityReceipt
        "burger" -> burgerPriceReceipt * quantityReceipt
        "salad" -> saladPriceReceipt * quantityReceipt
        else -> 0.0
    }

    // Optional discount (nullable)
    val discount: Double? = 5.0  // Try changing to null

    // Apply discount with Elvis operator
    val finalAmount = if (discount != null) {
        totalPrice - discount
    } else {
        totalPrice
    }

    // Print receipt
    println("========== RECEIPT ==========")
    println("Customer: $customerNameReceipt")
    println("Item: ${itemOrderedReceipt.uppercase()}")
    println("Quantity: $quantityReceipt")
    println("Subtotal: $${"%.2f".format(totalPrice)}")

    if (discount != null) {
        println("Discount: -$${"%.2f".format(discount)}")
    }

    println("Total: $${"%.2f".format(finalAmount)}")
    println("==============================")
}