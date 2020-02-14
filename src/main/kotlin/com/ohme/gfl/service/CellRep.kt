package com.ohme.gfl.service

import com.ohme.gfl.model.Cell
import com.ohme.gfl.model.Position

/**
 * cell status as alive or dead comparing to neighbors
 */
class CellRep(val cell: Cell) {

//    fun cellAtPosition(x: Int, y: Int): Cell
//    fun getWidth(): Int
//
//    fun getHeight(): Int
//
//    fun getSeeds(): List<Position>
    val neighbors: MutableList<Cell> = arrayListOf()

    fun evolve(livingNeighborsCount: Int = neighbors.count { it.isAlive }) {
        cell.isAlive = when(livingNeighborsCount) {
            0, 1 -> false
            2 -> cell.isAlive
            3 -> true
            else -> false
        }
    }
}
