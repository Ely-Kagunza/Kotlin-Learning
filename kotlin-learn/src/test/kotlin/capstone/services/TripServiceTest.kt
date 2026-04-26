package org.example.capstone.services

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking
import org.example.capstone.models.EconomyDriver
import kotlin.test.assertTrue

class TripServiceTest {
    @Test
    fun `economy returns economyDriver`() = runBlocking {
        val result = findAvailableDriver("economy")

        assertTrue(result is EconomyDriver)
        assertEquals(result.name, "James Karanja")
    }

    @Test
    fun `unknown type returns null`() = runBlocking {
        val driver = findAvailableDriver("unknown")

        assertEquals(null, driver)
    }
}