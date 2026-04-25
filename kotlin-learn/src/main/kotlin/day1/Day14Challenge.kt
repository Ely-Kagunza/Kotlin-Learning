package org.example.day1

enum class BookStatus {
    AVAILABLE,
    CHECKED_OUT,
    RESERVED,
    OVERDUE,
    LOST
}

enum class MembershipStatus {
    ACTIVE,
    CANCELLED,
    SUSPENDED,
    FLAGGED
}

abstract class LibraryItem(
    val title: String,
    val category: String,
    var status: BookStatus = BookStatus.AVAILABLE,
    val fineAmount: Double
) {
    open fun baseDescription(): String {
        return "$title ($category) -> $status"
    }
    abstract fun description(): String
}

class Book(
    title: String,
    category: String,
    status: BookStatus = BookStatus.AVAILABLE,
    fineAmount: Double,
    val noOfPages: Int
) : LibraryItem(title, category, status, fineAmount) {
    init {
        require(noOfPages > 100) { "Book too short"}
        println("Book $title created successfully")
    }
    constructor(title: String, category: String) : this(title, category, BookStatus.AVAILABLE, 500.0, 200)
    override fun description(): String {
        return "${baseDescription()} -> number of pages: $noOfPages"
    }
}

class Magazine(
    title: String,
    category: String,
    status: BookStatus = BookStatus.AVAILABLE,
    fineAmount: Double,
    val writer: String
) : LibraryItem(title, category, status, fineAmount) {
    constructor(title: String, category: String) : this(title, category, BookStatus.AVAILABLE, 900.0, "Harold")
    override fun description(): String {
        return "${baseDescription()} -> the writer is $writer"
    }
}

class AudioBook(
    title: String,
    category: String,
    status: BookStatus = BookStatus.AVAILABLE,
    fineAmount: Double,
    val hours: Int
) : LibraryItem(title, category, status, fineAmount) {
    constructor(title: String, category: String) : this(title, category, BookStatus.AVAILABLE, 500.0, 8)
    override fun description(): String {
        return "${baseDescription()} -> is $hours hours long"
    }
}

data class Member(
    val id: Int = 0,
    var name: String ="member",
    var membershipStatus: MembershipStatus = MembershipStatus.ACTIVE,
    var borrowedItems: List<LibraryItem> = listOf()
)

val books = listOf(
    Book("Into The Bad Lands", "Romance", BookStatus.AVAILABLE, 500.0, 200),
    Book("Person Of Interest", "Action"),
    Magazine("The Daily Nation", "Business", BookStatus.AVAILABLE, 800.0, "Finch"),
    Magazine("World Sports", "Sports"),
    AudioBook("Outlander", "Oldie", BookStatus.AVAILABLE, 500.0, 20),
    AudioBook("Mr.Pierce", "Comedy")
)

val booksTwo = listOf(
    Book("Into The Bad Lands", "Romance", BookStatus.AVAILABLE, 500.0, 200),
    Book("Person Of Interest", "Action"),
    Magazine("The Daily Nation", "Business", BookStatus.OVERDUE, 800.0, "Finch"),
    Magazine("World Sports", "Sports"),
    AudioBook("Outlander", "Oldie", BookStatus.OVERDUE, 500.0, 20),
    AudioBook("Mr.Pierce", "Comedy")
)

class InvalidLibraryItemProcessException(msg: String) : Exception(msg)

fun libraryAction(memberId: Int, memberName: String, items: List<LibraryItem> = listOf()): Member {
    require(items.isNotEmpty()) { "Items must not be empty" }
    return Member(memberId).apply {
        name = memberName
        membershipStatus = MembershipStatus.ACTIVE
        borrowedItems = items
    }
}

fun processBorrowedBooks(borrowed: List<LibraryItem>, penaltyMultiplier: Double = 1.0): String {
    require(penaltyMultiplier > 0.0) { "Penalty Multiplier must be greater than zero" }
    borrowed
        .also { println("\nProcessing ${it.size} borrowed books\n") }
        .map { book ->
            if (book.status != BookStatus.AVAILABLE) {
                throw InvalidLibraryItemProcessException("Book '${book.title}' must be AVAILABLE before processing. Current status: ${book.status}")
            }
            when (book) {
                is Book, is Magazine, is AudioBook -> book.status = BookStatus.OVERDUE
//                is Magazine -> book.status = BookStatus.OVERDUE
//                is AudioBook -> book.status = BookStatus.OVERDUE
            }
            val penalty = book.fineAmount * penaltyMultiplier
            println("Book '${book.title}' status changed to '${book.status}', Penalty incurred is KSh ${"%.2f".format(penalty)}")
        }

    val calculateTotalFine = borrowed.sumOf { it.fineAmount * penaltyMultiplier }

    println("\n--- Book Process Summary ---")
    println("Total books processed: ${borrowed.size}")
    println("Status for ${borrowed.size} books changed to OVERDUE")
    println("Total fine incurred: KSh ${"%.2f".format(calculateTotalFine)}\n")

    return "Total books processed: ${borrowed.size}\n"
}

fun fineRangeChecker(borrow: List<LibraryItem>): List<String> {
    return borrow.map { item ->
        when (item.fineAmount) {
            in 0.0..499.9 -> "  -> ${item.title} — Low"
            in 500.0..799.9 -> "  -> ${item.title} — High"
            else -> "  -> ${item.title} — Extreme"
        }
    }
}

fun librarySummary(client: Member): String {
    return client.run {
        val header = "Member $id"
        val lines = borrowedItems.map { item ->
            with (item) {
                " -> Book: $title, category: $category, status: $status"
            }
        }.joinToString("\n")
        val fines = borrowedItems.count { it.status == BookStatus.OVERDUE }
        val footer = "Total books borrowed: ${borrowedItems.size}\nTotal fines: $fines\n"
        "$header\n$lines\n$footer"
    }
}

fun main() {
    val result = runCatching {
        libraryAction(99, "Junior", books)
        processBorrowedBooks(books, 1.5)
    }

    result
        .onSuccess { confirmation ->
            println("[SUCCESS] $confirmation")
        }
        .onFailure { error ->
            println("[ERROR] ${error.message}")
        }

    println("\n")
    val memberOne = libraryAction(101, "Brooks", booksTwo)
    println(librarySummary(memberOne))

    println("--- Fine Range Classification ---")
    println(fineRangeChecker(memberOne.borrowedItems).joinToString("\n"))
}