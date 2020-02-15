package com.ohme.gfl.pattern

import com.ohme.gfl.service.Game

/**
 * Glider pattern for a 25*25 grid initiating alive cells from the middle
 */
class Glider : Game(25, 25) {
    init {
        setCellInitialState(12, 12)
        setCellInitialState(13, 13)
        setCellInitialState(14, 12)
        setCellInitialState(14, 13)
        setCellInitialState(13, 14)
    }
}
