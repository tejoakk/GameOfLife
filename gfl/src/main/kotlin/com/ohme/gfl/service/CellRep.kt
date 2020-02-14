package com.ohme.gfl.service

import com.ohme.gfl.model.Cell
import com.ohme.gfl.model.Position

interface CellRep {

    fun cellAtPosition(x: Int, y: Int): Cell
    fun getWidth(): Int

    fun getHeight(): Int

    fun getSeeds(): List<Position>
}
