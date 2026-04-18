package org.example.day1

// TODO 1: Create a class BankAccount
class BankAccount(internal val accountNumber: String, private var _balance: Double) {
    val balance: Double
        get() = _balance

    private fun logTransaction(type: String, amount: Double) {
        println("[$accountNumber] $type: KSh ${"%.2f".format(amount)}")
    }

    fun deposit(amount: Double): Double {
        if (amount > 0) {
            _balance += amount
            logTransaction("DEPOSIT",amount)
        }
        return _balance
    }

    fun withdraw(amount: Double): Double {
        if (amount > 0 && amount <= _balance) {
            _balance -= amount
            logTransaction("WITHDRAW",amount)
        }
        return _balance
    }
}

// TODO 2: Create a class Customer with id, name, email (use apply)
data class Client(var id: Int = 0, var name: String = "", var email: String = "")

fun main() {
    val client = Client().apply {
        id = 101
        name = "Kagunza"
        email = "K@gmail.com"
    }

    val account = BankAccount("ACC-101", 100.0)
    // account._balance = 200.0

    client.email.let { email ->
        println("The client email: $email\n")
    }

    account.deposit(500.0).also {
        println("Balance after deposit: KSh ${"%.2f".format(it)}\n")
    }

    val balance10Percent = account.run {
        balance * 0.1
    }
    println("Ten % of the balance: KSh ${"%.2f".format(balance10Percent)}\n")

    account.withdraw(300.0).also {
        println("Balance after withdraw: KSh ${"%.2f".format(it) }")
    }

    with(account) {
        println("The balance for account [$accountNumber] is KSh ${"%.2f".format(balance)}")
    }
}