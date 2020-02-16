package com.ohme.gfl.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CellTest {
     val cell = Cell(5, 5)

    @Test
    fun validateState() {
        cell.validateState(0)
        assertFalse(cell.isAlive)
        cell.validateState(1)
        assertFalse(cell.isAlive)
        cell.validateState(2)
        assertFalse(cell.isAlive)
        cell.validateState(3)
        assertTrue(cell.isAlive)
        cell.validateState(4)
        assertFalse(cell.isAlive)
    }

    @Test
    fun testShowPositionForAlive() {
        cell.isAlive = true
       val result = cell.showPosition()
        assertEquals(result, "X")
    }

    @Test
    fun testShowPositionForDead() {

        cell.isAlive = false
        val result = cell.showPosition()
        assertEquals(result, ".")
    }
    @Test
    fun addCount() {
        cell.isAlive = true
        val result = cell.addCount()
        assertEquals(result, 1)
    }
}
