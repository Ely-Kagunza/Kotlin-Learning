package org.example.finalproject.cinetrack.utils

fun Double.toKsh(): String {
    return "KSh %.2f".format(this)
}

fun String.isValidEmail(): Boolean {
    return contains("@") && contains(".")
}

fun <T> List<T>.secondOrNullCustom(): T? {
    return if (size > 1) this[1] else null
}

fun <T : Number> List<T>.sumAsDouble(): Double {
    return sumOf { it.toDouble() }
}