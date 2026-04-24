package org.example.day1

// TODO 1: Create a base MenuItem class with name and price
abstract class MenuItem(val name: String, val price: Double) {
    constructor(name: String) : this(name, 100.0)
    init {
        require(name.isNotBlank()) { "Name cannot be empty" }
        require(price > 0.0) { "Price must be positive, got $price" }
        println("We are ready to go")
    }
    open fun description(): String {
        return "$name - ${"%.2f".format(price)}"
    }
}

// TODO 2: Create Burger and Pizza classes that inherit from MenuItem
// TODO 3: Override description() to show item-specific info
class Burger(name: String, price: Double, val hasTopping: Boolean = true) : MenuItem(name, price) {
    constructor(name: String) : this(name, 300.0, false)
    override fun description(): String {
        return "${super.description()} (Topping: $hasTopping)"
    }
}

class Pizza(name: String, price: Double, val size: String = "Medium") : MenuItem(name, price) {
    constructor(name: String) : this(name, 100.0, "Medium")
    override fun description(): String {
        return "${super.description()} (Size: $size)"
    }
}

// TODO 4: Create a data class Customer with id, name, email
data class Customer (val id: Int, val name: String, val email: String)

// Billable interface
interface Billable {
    fun calculateTotal(): Double
    fun printBill()
}

// TODO 5: Create an Order class that:
class Order(val orderId: String,
            val customer: Customer
): Billable {
    private val _items: MutableList<MenuItem> = mutableListOf()
    val items: List<MenuItem>
        get() = _items.toList()

    fun addItem(item: MenuItem) {
        _items.add(item)
    }

    override fun calculateTotal(): Double {
        return _items.sumOf { it.price }
    }

    override fun printBill() {
        println("---- Billing ----")
        println("Order # $orderId")
        println("Customer Name : ${customer.name}")
        _items.forEach { item ->
            println("  -> ${item.description()}")
        }
        println("Total: KSh ${"%.2f".format(calculateTotal())}")
    }
}

// TODO 6: Create an extension function on Order that applies discount
fun Order.applyDiscount(percentage: Double): Double {
    val discount = calculateTotal() * (percentage / 100.0)
    return calculateTotal() - discount
}

fun main() {
    val pizza = Pizza("Pizza", 500.0, "Large")
    val burger = Burger("Burger", 450.0, true)
    val pizza2 = Pizza("Pepperoni")
    val pizza1 = Pizza("Margherita", 500.0)     // primary
    val burger1 = Burger("Beef", 450.0, true)   // primary
    val burger2 = Burger("Chicken")

    println("$pizza, $burger, $pizza2, $burger1, $burger2")

    val firstCustomer = Customer(101, "Elly", "ely@gmail.com")

    val firstOrder = Order("ORD-1", firstCustomer)

    firstOrder.addItem(pizza)
    firstOrder.addItem(burger)
    // firstOrder.addItem(salad)

    firstOrder.printBill()

    val discount = firstOrder.applyDiscount(15.0)
    println("Order total after a 15% discount: ${"%.2f".format(discount)}")
}