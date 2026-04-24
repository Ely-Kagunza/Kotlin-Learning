package org.example.day1

data class Clientele(
    var id: Int = 0,
    var name: String = "",
    var email: String? = null,
    var loyaltyPoints: Int = 0
)

val customers = listOf(
    Clientele(1, "Alice", "alice@kitchen.com", 120),
    Clientele(2, "Bob", null, 45),
    Clientele(3, "Charlie", "charlie@kitchen.com", 300),
    Clientele(4, "Diana", "diana@kitchen.com", 15)
)

fun newCustomer(id: Int, name: String): Clientele {
    return Clientele().apply {
        this.id = id
        this.name = name
    }
}

fun emailDomain(customer: Clientele): String? {
    val domain = customer.email?.let { it.substringAfter("@")}
    return domain
}

fun goldMembers(list: List<Clientele>): List<Clientele> {
    val goldMembers = list
        .also {println("List unfiltered $it")}
        .filter { it.loyaltyPoints >= 100 }
        .also {println("List filtered $it")}

    return goldMembers
}

fun discountLabel(customer: Clientele): String {
    return customer.run {
        "$name gets 10% off (KSh ${loyaltyPoints * 2})"
    }
}

fun main() {
    val c1 = newCustomer(99, "Eve")
    println("$c1\n")

    customers.forEach {
        println("${it.name}: ${emailDomain(it) ?: "no email"}")
    }

    val gold = goldMembers(customers)
    println("\n$gold\n")

    customers.forEach {
        println(discountLabel(it))
    }

    with(customers[0]) {
        println("\nname: $name, email: $email, loyaltyPoints: $loyaltyPoints")
    }
}