package org.example.day1

// TODO 1: Create sealed class ApiResponse with Success Error, Processing
sealed class ApiResponse {
    data class Success(val data: String, val total: Double) : ApiResponse()
    data class Error(val message: String) : ApiResponse()
    object Processing: ApiResponse()
}

// TODO 2: Create enum OrderStatus with at least 4 statuses
enum class OrderStatus(val description: String) {
    PENDING("Order is pending"),
    PROCESSING("Order is processing"),
    ACCEPTED("Order is accepted"),
    REJECTED("Order is rejected"),
}

// TODO 3: Create Order class with:
class Orders private constructor(
    val id: String,
    private var _total: Double = 0.0,
    var status: OrderStatus = OrderStatus.PENDING
) {
    val total: Double
        get() = _total

    fun addCharge(amount: Double): Double {
        if (amount > 0) {
            _total += amount
        }
        return total
    }

    fun applyDiscount(discount: Double) {
        require (discount in 0.0..100.0) { "Discount must be between 0 and 100" }
        _total *= (1 - discount / 100.0)
    }

    // TODO 4: Companion object that, Tracks totalOrdersCreated, Tracks dailyRevenue, Has factory method createOrder()
    companion object {
        var totalOrdersCreated: Int = 0
            private set
        var dailyRevenue: Double = 0.0
            private set

        fun createOrder(totalSold: Double): Orders {
            val order = Orders("order-${(++totalOrdersCreated)}", totalSold)
            dailyRevenue += totalSold
            return order
        }
    }
}

// TODO 5: Create object ApiConfig (singleton) with properties
object ApiConfig {
    const val urlPath: String = "https://www.day5.com"
    const val timeout = 30
}

object OrderService {
    fun processOrders(order: Orders): ApiResponse {
        return when {
            order.total <= 0 -> ApiResponse.Error("Total is less than zero")
            order.status == OrderStatus.REJECTED -> ApiResponse.Error("Order is rejected")
            else -> ApiResponse.Success(order.id, order.total)
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

    val response = OrderService.processOrders(orderTwo)
    when (response) {
        is ApiResponse.Success -> println("Order ${response.data} processed for KSh ${"%.2f".format(response.total)}\n")
        is ApiResponse.Error -> println("Error ${response.message}\n")
        is ApiResponse.Processing -> println("Processing...\n")
    }

    val totalOrderCreated = Orders.totalOrdersCreated
    println("Total orders created: $totalOrderCreated")
    val dailyRevenue = Orders.dailyRevenue
    println("Daily revenue: $dailyRevenue")
}