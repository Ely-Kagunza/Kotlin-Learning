package org.example.day1


fun formatCurrency(amount: Double): String = "KSh ${"%.2f".format(amount)}"
// TODO 1: Create a class BankAccount
class BankAccount(internal val accountNumber: String, private var _balance: Double) {
    val balance: Double
        get() = _balance

    private fun logTransaction(type: String, amount: Double) {
        println("[$accountNumber] $type: ${formatCurrency(amount)}")
    }

    fun deposit(amount: Double): Double {
        require(amount > 0.0) { "$amount should be greater than zero." }
        _balance += amount
        logTransaction("DEPOSIT", amount)
        return _balance
    }

    fun withdraw(amount: Double): Double {
        require(amount > 0.0 ) { "amount must be positive." }
        check(amount <= _balance) { "Insufficient funds." }
        _balance -= amount
        logTransaction("WITHDRAW", amount)
        return _balance
    }
}

// TODO 2: Create a class Customer with id, name, email (use apply)
data class Client(var id: Int = 0, var name: String = "", var email: String? = "")

fun formatBalance(label: String, amount: Double): String {
    return "$label: ${formatCurrency(amount)}\n"
}

fun main() {
    val client = Client().apply {
        id = 101
        name = "Kagunza"
        email = "K@gmail.com"
    }

    val account = BankAccount("ACC-101", 100.0)
    // account._balance = 200.0

    client.email?.let { email ->
        println("The client email: $email\n")
    }

    account.deposit(500.0).also {
        println(formatBalance("Balance after deposit", it))
    }


    val balance10Percent = account.run {
        balance * 0.1
    }
    println("Ten % of the balance: ${formatCurrency(balance10Percent)}\n")

    account.withdraw(300.0).also {
        println(formatBalance("Balance after withdraw", it))
    }

    with(account) {
        println("The balance for account [$accountNumber] is ${formatCurrency(balance)}")
    }
}