package com.ohme.gfl.model

/**
 * data class to represent the list of cells, total alive, total dead and new births
 */

data class Grid(
    val cells: List<List<Cell>>? = emptyList(),
    val numAliveCells: Int? = 0,
    val currentBirths: Int? = 0,
    val numDeadCells: Int? = 0)
