package com.ohme.gfl.model

/**
 * data class to represent whether the cell is live or dead and it's position
 */

data class Cell(val isAlive: Boolean, val position: Position) {
    override fun toString() = "isAlive $isAlive"
}

