package com.ohme.gfl.model

import com.ohme.gfl.constants.Constants

/**
 * class to represent whether the cell is live or dead and it's position
 */

class Cell {
    var isAlive: Boolean = false
    val position: Position

    /**
     * rule validator for each cell
     */
    fun validateState(aliveNeighbourCount: Int) {
        isAlive = when (aliveNeighbourCount) {
            0, 1 -> false
            2  -> isAlive
            3  -> true
            else -> false
        }
    }

}

