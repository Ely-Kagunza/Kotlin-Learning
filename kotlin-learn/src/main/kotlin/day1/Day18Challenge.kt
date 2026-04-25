package org.example.day1

fun <T : Number> doubleValue(value: T): Double {
    return value.toDouble() * 2
}

fun <T : Comparable<T>> biggerValue(a: T, b: T): T {
    return if (a > b) a else b
}

abstract class LibraryResource(
    val id: String,
    val title: String
)

class PrintedBook(id: String, title: String, val pages: Int) : LibraryResource(id, title)
class DigitalBook(id: String, title: String, val fileSizeMb: Double) : LibraryResource(id, title)

fun <T : LibraryResource> printResource(resource: T): String {
    return with(resource) {
        "Resource ID: $id, Title: $title"
    }
}

fun main() {
    val listOfNumbers = listOf(10, 15.5, 100L)

    println("--- Number Bound ---")
    listOfNumbers.forEach { no ->
        println(doubleValue(no))
    }

    println("\n--- Comparable Bound ---")
    println(biggerValue(10, 20))
    println(biggerValue("Alice", "Bob"))

    println("\n--- Domain Bound ---")
    val printedBook = PrintedBook("P-BOOK-001", "Try It", 500)
    val digitalBook = DigitalBook("D-BOOK-001", "Yeah", 3456.0)

    println(printResource(printedBook))
    println(printResource(digitalBook))
}