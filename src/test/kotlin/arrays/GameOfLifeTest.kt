package arrays

import junit.framework.TestCase

class GameOfLifeTest : TestCase() {

    fun testGameOfLife() {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0),
        )
        GameOfLife().gameOfLife(board)
        println(board.contentDeepToString())
    }
}
