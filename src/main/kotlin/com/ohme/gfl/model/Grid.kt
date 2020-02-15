package com.ohme.gfl.model

/**
 * class to represent the current state and previous state of the Game
 * list of cells, total alive, total dead and new births
 */

class Grid{
    lateinit var grid: Array<Array<Cell?>>
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

    /**
     * initiate cell state
     */
    fun setCell(i: Int, j: Int) {
        val cell = Cell(i + 1, j + 1, true)
        grid[i + 1][j + 1] = cell
        numAliveCells++
    }

    /**
     * get alive 8 neighbours count
     * TODO consider the corners/edges logic
     */
    fun getLiveNeighbourCount(i: Int, j: Int, previousState: Grid?): Int {
        var count = 0
        count += if (previousState!!.grid[i - 1][j - 1]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i - 1][j]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i - 1][j + 1]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i][j - 1]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i][j + 1]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i + 1][j - 1]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i + 1][j]?.isAlive!!)  1 else 0
        count += if (previousState.grid[i + 1][j + 1]?.isAlive!!)  1 else 0
        return count
    }

}
