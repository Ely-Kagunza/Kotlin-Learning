package org.example.day1

fun <T> List<T>.secondItemOrNull(): T? {
    return if (size > 1) this[1] else null
}

class Box<T>(val value: T) {
    fun describe(): String {
        return "Box contains: $value"
    }

    fun <R> map(transform: (T) -> R): Box<R> {
        return Box(transform(value))
    }
}

fun main() {
    val listOfString = listOf("Alice", "Bob", "Charlie")
    val listOfInt = listOf(10, 20, 30)
    val listOfDouble = listOf(99.5)

    println(listOfString.secondItemOrNull())
    println(listOfInt.secondItemOrNull())
    println(listOfDouble.secondItemOrNull())

    val nameBox = Box("Kotlin")
    println(nameBox.describe())
    val numberBox = Box(500)
    val textBox = numberBox.map { it.toString() }
    println(textBox.describe())
}