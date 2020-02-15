package com.ohme.gfl.model

import com.ohme.gfl.pattern.Glider

/**
 * class to represent the current state and previous state of the Game
 * list of cells, total alive, total dead and new births
 */

class Grid{
    lateinit var grid: Array<Array<Cell?>>
    var numAliveCells = 0
    var currentBirths = 0
    var currentDeaths = 0

}
