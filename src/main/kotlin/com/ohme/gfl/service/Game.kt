package com.ohme.gfl.service

import com.ohme.gfl.model.Grid

/**
 * Game of life
 */
open class Game {
    private var currentState: Grid? = null
    private var previousState: Grid? = null
    private var deaths = 0
    private var born = 0
    private var actives = 0
    private var dead = 0
    private var rows = 0
    private var columns = 0

    /**
     * constructor to initiate Grids
     */
    constructor(m: Int, n: Int) {
        rows = m
        columns = n
        currentState = Grid(m, n)
        previousState = Grid(m, n)
        deaths = 0
        born = 0
        actives = 0
        dead = m * n
    }

    /**
     * set the initial state of the grid
     */
    fun setCellInitialState(i: Int, j: Int) {
        currentState?.setCell(i, j)
        actives++
        dead--
    }
}
