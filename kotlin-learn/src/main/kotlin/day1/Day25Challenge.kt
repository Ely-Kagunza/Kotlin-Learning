//package org.example.day1
//
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.filter
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.runBlocking
//
//data class BookingUpdate(
//    val bookingId: String,
//    val customerName: String,
//    val seats: Int,
//    val status: String
//)
//
//fun bookingUpdatesFlow(): Flow<BookingUpdate> = flow {
//    emit(BookingUpdate("B-1", "John", 4, "CONFIRMED"))
//    delay(500)
//    emit(BookingUpdate("B-2", "Elly", 3, "PENDING"))
//    delay(500)
//    emit(BookingUpdate("B-3", "Sunny", 4, "CONFIRMED"))
//    delay(500)
//    emit(BookingUpdate("B-4", "Jack", 3, "CANCELLED"))
//    delay(500)
//    emit(BookingUpdate("B-5", "Jay", 4, "CONFIRMED"))
//}
//
//fun main(): Unit = runBlocking {
//    println("--- Raw Booking Updates ---")
//    bookingUpdatesFlow().collect { update ->
//        println(update)
//    }
//
//    println("\n--- Confirmed Booking Summaries ---")
//    bookingUpdatesFlow()
//        .filter { it.status == "CONFIRMED" }
//        .map { "${it.bookingId}: ${it.customerName} booked ${it.seats} seats" }
//        .collect { summary ->
//            println(summary)
//        }
//}