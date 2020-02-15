package com.ohme.gfl.pattern

import com.ohme.gfl.service.Game

/**
 * Glider pattern for a 25*25 grid initiating cells  from the middle
 */
class Glider : Game(25, 25) {
    init {
        setCellInitialState(11, 10)
        setCellInitialState(12, 11)
        setCellInitialState(13, 9)
        setCellInitialState(13, 10)
        setCellInitialState(13, 11)
    }
}
