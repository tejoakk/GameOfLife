



package com.ohme.gfl.model

import com.ohme.gfl.pattern.Glider

/**
 * class to represent the current state and previous state of the Game
 * list of cells, total alive, total dead and new births
 */

class Grid{
    var grid: Array<Array<Cell?>>
    var numAliveCells = 0
    var currentBirths = 0
    var currentDeaths = 0

    /**
     * constructor by no of rows and columns
     */
    constructor(m: Int, n: Int) {
        grid = Array(m+2) { arrayOfNulls<Cell>(n +2) }
        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                grid[i][j] = Cell(i, j)
            }
        }
    }

    fun setCell(i: Int, j: Int) {
        val cell = Cell(i + 1, j + 1, true)
        grid[i + 1][j + 1] = cell
        numAliveCells++
    }

    /**
     * logic to change the glider state of next grid
     * looping through the rows
     */
    fun changeStates(oldGrid: Grid?) {
        currentBirths = 0
        currentDeaths = 0
        for (i in 1 until grid.size - 1) {
            for (j in 1 until grid[i].size - 1) {
                state(i, j, oldGrid)
            }
            // reset the grid
            if(i == grid.size-2 && numAliveCells == 3){
                currentBirths = 0
                currentDeaths = 0
                Glider().start()
            }
        }
    }

    /**
     * logic to change the grid state looping through the columns
     */
    private fun state(i: Int, j: Int, oldGrid: Grid?) {
        val neighbourCount = getLiveNeighbourCount(i, j, oldGrid)
        val previousState = grid[i][j]?.isAlive
        grid[i][j]!!.validateState(neighbourCount)
        val newState = grid[i][j]?.isAlive
        if (previousState != newState) {
            if (newState!!) {
                numAliveCells++
                currentBirths++
            } else {
                numAliveCells--
                currentDeaths++
            }
        }
    }

    /**
     * get alive 8 neighbours count
     * TODO consider the corners/edges logic
     */
    fun getLiveNeighbourCount(i: Int, j: Int, oldGrid: Grid?): Int {
        var count = 0
        count += oldGrid!!.grid[i - 1][j - 1]?.addCount() ?: 0
        count += oldGrid.grid[i - 1][j]?.addCount() ?: 0
        count += oldGrid.grid[i - 1][j + 1]?.addCount() ?: 0
        count += oldGrid.grid[i][j - 1]?.addCount() ?: 0
        count += oldGrid.grid[i][j + 1]?.addCount() ?: 0
        count += oldGrid.grid[i + 1][j - 1]?.addCount() ?: 0
        count += oldGrid.grid[i + 1][j]?.addCount() ?: 0
        count += oldGrid.grid[i + 1][j + 1]?.addCount() ?: 0
        return count
    }

    /**
     * clone grid from previous grid
     */
    fun cloneGridFrom(grid1: Grid?) {
        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                grid1!!.grid[i][j]?.isAlive?.let { grid[i][j]?.let { it1 -> it1(isAlive = it) } }

            }
        }
    }

    /**
     * print the 'X' and '.'
     */
    override fun toString(): String {
        val gridString = StringBuilder()
        for (i in 1 until grid.size - 1) {
            for (j in 1 until grid[i].size - 1) {
                gridString.append(grid[i][j]?.showPosition())
            }
            gridString.append("\n")
        }
        return gridString.toString()
    }

    val numDeadCells: Int
        get() = (grid.size - 2) * (grid[0].size - 2) - numAliveCells

}

