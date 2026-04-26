package org.example.day1

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class BankAccountTest {
    @Test
    fun `deposit increases balance`() {
        val account = BankAccount("ACC-101", 100.0)

        account.deposit(500.0)

        assertEquals(600.0, account.balance)
    }

    @Test
    fun `withdraw decreases balance`() {
        val account = BankAccount("ACC-101", 600.0)

        account.withdraw(300.0)

        assertEquals(300.0, account.balance)
    }

    @Test
    fun `deposit negative amount fails`() {
        val account = BankAccount("ACC-101", 100.0)

        assertFailsWith<IllegalArgumentException> {
            account.deposit(-50.0)
        }
    }

    @Test
    fun `withdraw negative amount fails`() {
        val account = BankAccount("ACC-101", 100.0)

        assertFailsWith<IllegalStateException> {
            account.withdraw(200.0)
        }
    }

    @Test
    fun `withdraw more than balance`() {
        val account = BankAccount("ACC-101", 100.0)

        assertFailsWith<IllegalStateException> {
            account.withdraw(200.0)
        }
    }
}