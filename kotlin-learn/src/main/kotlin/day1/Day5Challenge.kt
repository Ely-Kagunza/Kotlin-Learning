package org.example.day1

// TODO 1: Create sealed class ApiResponse with Success Error, Processing
sealed class ApiResponse

data class Success(val data: String, val total: Double) : ApiResponse()
data class Error(val message: String) : ApiResponse()
object Processing: ApiResponse()

// TODO 2: Create enum OrderStatus with at least 4 statuses
enum class OrderStatus(val description: String) {
    PENDING("Order is pending"),
    PROCESSING("Order is processing"),
    ACCEPTED("Order is accepted"),
    REJECTED("Order is rejected"),
}

// TODO 3: Create Order class with:
data class Orders(val id: String, private var _total: Double = 0.0, var status: OrderStatus = OrderStatus.PENDING) {
    val total: Double
        get() = _total

    fun addCharge(amount: Double): Double {
        if (amount > 0) {
            _total += amount
        }
        return total
    }

    fun applyDiscount(discount: Double) {
        _total *= (1 - discount / 100.0)
    }

    // TODO 4: Companion object that, Tracks totalOrdersCreated, Tracks dailyRevenue, Has factory method createOrder()
    companion object {
        var totalOrdersCreated = 0
        var dailyRevenue: Double = 0.0

        fun createOrder(totalSold: Double): Orders {
            val order = Orders("order-${(1 + totalOrdersCreated++)}", totalSold, OrderStatus.PENDING)
            dailyRevenue += totalSold
            return order
        }
    }
}

// TODO 5: Create object ApiConfig (singleton) with properties
object ApiConfig {
    val urlPath: String = "https://www.day5.com"
    val timeout = 30

    fun processOrders(order: Orders): ApiResponse {
        return when {
            order.total <= 0 -> Error("Total is less than zero")
            order.status == OrderStatus.REJECTED -> Error("Order is rejected")
            else -> Success(order.id, order.total)
        }
    }
}

fun main() {
    println("==== Kitchen Command Orders ====\n")
    val orderOne = Orders.createOrder(150.0)
    val orderTwo = Orders.createOrder(300.0)
    val orderThree = Orders.createOrder(400.0)

    val newTotalOne = orderOne.addCharge(150.0)
    println("New total for OrderOne = KSh ${"%.2f".format(newTotalOne)}")
    println("Order Three details: ID-> ${orderThree.id}, Total->${orderThree.total}, Status: ${orderThree.status.description}\n")

    val response = ApiConfig.processOrders(orderTwo)
    when (response) {
        is Success -> println("Order ${response.data} processed for KSh ${"%.2f".format(response.total)}\n")
        is Error -> println("Error ${response.message}\n")
        is Processing -> println("Processing...\n")
    }

    val totalOrderCreated = Orders.totalOrdersCreated
    println("Total orders created: $totalOrderCreated")
    val dailyRevenue = Orders.dailyRevenue
    println("Daily revenue: $dailyRevenue")
}