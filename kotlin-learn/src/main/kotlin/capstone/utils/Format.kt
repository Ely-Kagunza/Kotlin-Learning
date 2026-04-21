package org.example.capstone.utils

fun formatCurrency(amount: Double): String {
    return "KSh ${"%.2f".format(amount)}"
}