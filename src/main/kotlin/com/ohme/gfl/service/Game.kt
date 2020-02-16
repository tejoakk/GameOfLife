package com.ohme.gfl.service

import com.ohme.gfl.model.Grid
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

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
     * constructor with rows and columns
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
     * represent the current state of grid
     */
    fun tick() {
        previousState!!.cloneGridFrom(currentState)
        currentState!!.changeStates(previousState)
        born += currentState!!.currentBirths
        deaths += currentState!!.currentDeaths
        actives = currentState!!.numAliveCells
        dead = currentState!!.numDeadCells
        println(currentState)
    }

    /**
     * set the initial state of the grid
     */
    fun setCellInitialState(i: Int, j: Int) {
        currentState?.setCell(i, j)
        actives++
        dead--
    }

    /**
     * start the game and loop through
     */
    fun start() {
        while (true) {
            try {
                Thread.sleep(500)
                tick()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}

