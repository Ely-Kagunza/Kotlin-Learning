package org.example.day1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class BookingEvent(
    val bookingId: String,
    val customerName: String,
    val seats: Int,
    val status: String
)

data class BookingMonitorState(
    val processedBookings: List<BookingEvent> = emptyList(),
    val rejectedBookings: List<BookingEvent> = emptyList(),
)

fun bookingEventFlow(): Flow<BookingEvent> = flow {
    emit(BookingEvent("BK-1", "Fusco", 4, "CONFIRMED"))
    delay(500)
    emit(BookingEvent("BK-2", "Gorge", 0, "PENDING"))
    delay(500)
    emit(BookingEvent("BK-3", "Scott", 3, "CANCELLED"))
    delay(500)
    emit(BookingEvent("BK-4", "Jim", 4, "CONFIRMED"))
    delay(500)
    emit(BookingEvent("BK-5", "Reese", 5, "CANCELLED"))
}

class BookingMonitor {
    private val _state = MutableStateFlow(BookingMonitorState())
    val state: StateFlow<BookingMonitorState> = _state.asStateFlow()

    suspend fun processEvents(events: Flow<BookingEvent>) {
        events.collect { event ->
            when {
                event.seats <= 0 -> _state.update { state ->
                    state.copy(rejectedBookings = state.rejectedBookings + event)
                }

                event.status != "CONFIRMED" -> _state.update { state ->
                    state.copy(rejectedBookings = state.rejectedBookings + event)
                }

                else -> _state.update { state ->
                    state.copy(processedBookings = state.processedBookings + event)
                }
            }
        }
    }
}

fun main() = runBlocking {
//    bookingEventFlow()
//        .filter { it.seats >= 0 && it.status == "CONFIRMED" }
//        .map { "Booking for ${it.customerName} for seats: ${it.seats}" }
//        .collect { item ->
//            println(item)
//        }

    val monitor = BookingMonitor()
    val watcherJob = launch {
        monitor.state.collect { state ->
            println("STATE: processed=${state.processedBookings.size}, rejected=${state.rejectedBookings.size}")
        }
    }

    val processorJob = launch {
        monitor.processEvents(bookingEventFlow())
    }

    processorJob.join()
    watcherJob.cancel()
}