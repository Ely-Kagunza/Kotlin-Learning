package org.example.finalproject.cinetrack

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.example.finalproject.cinetrack.repository.CinemaRepository
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RepositoryFlowTest {
    @Test
    fun `fetchMovies returns non-empty list`() = runBlocking {
        val repo = CinemaRepository()

        val movies = repo.fetchMovies()

        assertTrue(movies.isNotEmpty())
    }

    @Test
    fun `fetchCustomer returns customer for valid ID`() = runBlocking {
        val repo = CinemaRepository()

        val customer = repo.fetchCustomer("CT-3")

        assertEquals("Charlie", customer?.name)
    }

    @Test
    fun `fetchCustomer returns null for invalid ID`() = runBlocking {
        val repo = CinemaRepository()

        val customer = repo.fetchCustomer("CT-4")

        assertNull(customer)
    }

    @Test
    fun `bookingevents toList returns 5 events`() = runBlocking {
        val repo = CinemaRepository()

        val bookingEvents = repo.bookingEvents().toList()

        assertEquals(5, bookingEvents.size)
    }

}