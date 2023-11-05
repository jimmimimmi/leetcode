package arrays

// https://leetcode.com/problems/game-of-life/submissions/
class GameOfLife {
    fun gameOfLife(board: Array<IntArray>) {
        val neighbours: Array<Pair<Int, Int>> = arrayOf(
            -1 to -1,
            -1 to 0,
            -1 to 1,
            0 to -1,
            0 to 1,
            1 to -1,
            1 to 0,
            1 to 1,
        )

        val rows = board.size
        val cols = board[0].size

        val result = Array(rows) { IntArray(cols) { 0 } }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                val sum = neighbours.map {
                    i + it.first to j + it.second
                }.filter {
                    it.first >= 0 && it.second >= 0 &&
                        it.first < rows && it.second < cols
                }.map { board[it.first][it.second] }.sum()

                val cell = board[i][j]
                val nextVal =
                    if (sum < 2) {
                        0
                    } else if (cell == 1 && (sum == 2 || sum == 3)) {
                        1
                    } else if (cell == 1) {
                        0
                    } else if (cell == 0 && sum == 3) {
                        1
                    } else {
                        0
                    }

                result[i][j] = nextVal
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                board[i][j] = result[i][j]
            }
        }
    }
}
