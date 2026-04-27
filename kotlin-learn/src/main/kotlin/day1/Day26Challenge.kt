package org.example.day1

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.asSharedFlow

data class CinemaUiState(
    val loading: Boolean = false,
    val bookings: List<String> = emptyList(),
    val error: String? = null
)

class CinemaViewModelFake {
    private val _uiState = MutableStateFlow(CinemaUiState())
    val uiState: StateFlow<CinemaUiState> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<String>()
    val events: SharedFlow<String> = _events.asSharedFlow()

    suspend fun loadBookings() {
        _uiState.update { state ->
            state.copy(
                loading = true,
                error = null
            )
        }

        delay(1000)

        _uiState.update { state ->
            state.copy(
                loading = false,
                bookings = listOf("B-1", "B-2", "B-3"),
                error = null
            )
        }

        _events.emit("Bookings loaded successfully")
    }

    suspend fun failLoading() {
        _uiState.update { state ->
            state.copy(
                loading = true,
            )
        }

        delay(500)

        _uiState.update { state ->
            state.copy(
                loading = false,
                error = "Failed to load bookings."
            )
        }

        _events.emit("Loading failed")
    }
}

fun main() = runBlocking {
    val cm = CinemaViewModelFake()

    val stateJob = launch {
        cm.uiState.collect { state ->
            println("STATE: $state")
        }
    }

    val eventJob = launch {
        cm.events.collect { event ->
            println("EVENT: $event")
        }
    }

    cm.loadBookings()
    cm.failLoading()

    delay(100)

    stateJob.cancel()
    eventJob.cancel()
}