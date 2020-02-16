package com.ohme.gfl.model

import com.ohme.gfl.constants.Constants

/**
 * class to represent whether the cell is live or dead and it's position
 */

class Cell {
    var isAlive: Boolean = false
    var position: Position

    constructor(i: Int, j: Int){
        this.isAlive = false
        this.position = Position(i, j)
    }
    constructor(i: Int, j: Int, isAlive: Boolean)  {
        this.isAlive = isAlive
        this.position = Position(i, j)
    }
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

    operator fun invoke(isAlive: Boolean) {
        this.isAlive = isAlive
    }

    /**
     *  display 'X' for alive and '.' for dead
     */
    fun showPosition(): String = if(isAlive) Constants.aliveCell else Constants.deadCell

    /**
     *  add counts for alive cells
     */
    fun addCount(): Int = if (isAlive) 1 else 0
}


