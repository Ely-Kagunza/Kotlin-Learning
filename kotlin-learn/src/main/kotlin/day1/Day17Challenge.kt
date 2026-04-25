package org.example.day1

fun <T> secondItem(items: List<T>): T? {
    return if (items.size > 1) items[1] else null
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

    println(secondItem(listOfString))
    println(secondItem(listOfInt))
    println(secondItem(listOfDouble))

    val nameBox = Box("Kotlin")
    println(nameBox.describe())
    val numberBox = Box(500)
    val textBox = numberBox.map { it.toString() }
    println(textBox.describe())
}