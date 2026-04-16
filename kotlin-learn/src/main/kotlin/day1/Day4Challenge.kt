package org.example.day1

// TODO 1: Create a base MenuItem class with name and price
open class MenuItem(val name: String, val price: Double) {
    open fun descriptor(): String {
        return "$name - ${"%.2f".format(price)}"
    }
}

// TODO 2: Create Burger and Pizza classes that inherit from MenuItem
// TODO 3: Override description() to show item-specific info
class Burger(name: String, price: Double, val hasTopping: Boolean = true) : MenuItem(name, price) {
    override fun descriptor(): String {
        return "${super.descriptor()} (Topping: $hasTopping)"
    }
}

class Pizza(name: String, price: Double, val size: String = "Medium") : MenuItem(name, price) {
    override fun descriptor(): String {
        return "${super.descriptor()} (Size: $size)"
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
class Order(val orderId: String, val customer: Customer, val items: MutableList<MenuItem> = mutableListOf()): Billable {
    override fun calculateTotal(): Double {
        return items.sumOf { it.price }
    }

    override fun printBill() {
        println("---- Billing ----")
        println("Order # $orderId")
        println("Customer Name : ${customer.name}")
        items.forEach { item ->
            println("  -> ${item.descriptor()}")
        }
        println("Total: KSh ${"%.2f".format(calculateTotal())}")
    }

    fun addItem(item: MenuItem) {
        items.add(item)
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
    val salad = MenuItem("Salad", 2000.0)

    val firstCustomer = Customer(101, "Elly", "ely@gmail.com")

    val firstOrder = Order("ORD-1", firstCustomer)

    firstOrder.addItem(pizza)
    firstOrder.addItem(burger)
    firstOrder.addItem(salad)

    firstOrder.printBill()

    val discount = firstOrder.applyDiscount(15.0)
    println("Order total after a 15% discount: ${"%.2f".format(discount)}")
}