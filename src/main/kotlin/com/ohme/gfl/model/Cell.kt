package com.ohme.gfl.model

/**
 * data class to represent whether the cell is live or dead and it's position
 */

data class Cell(var isAlive: Boolean = false, val position: Position? = Position(0,0)) {
    override fun toString() = "isAlive $isAlive"
}

