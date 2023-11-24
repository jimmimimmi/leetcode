package educative.self

import kotlin.math.*

// https://leetcode.com/problems/rotting-oranges/description/
class RottingOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val visited = HashSet<Pair<Int, Int>>()
        var res = 0

        val queue = ArrayDeque<Pair<Pair<Int, Int>, Int>>()

        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 2) {
                    queue.addLast((i to j) to 0)
                }
            }
        }

        val neighbours = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
        while (queue.isNotEmpty()) {
            // println("\nwhile. begin. queue $queue, visited $visited")
            val size = queue.size
            for (k in 0 until size) {
                val (currCell, depth) = queue.removeFirst()
                // println("while. currCell $currCell, depth $depth, isVisited ${visited.contains(currCell)}")
                if (!visited.contains(currCell)) {
                    visited.add(currCell)
                    res = max(res, depth)
                    neighbours.forEach { next ->
                        val row = next.first + currCell.first
                        val col = next.second + currCell.second
                        if (
                            row >= 0 && col >= 0 && row < grid.size && col < grid[0].size &&
                            !visited.contains(row to col) && grid[row][col] == 1
                        ) {
                            queue.addLast((row to col) to depth + 1)
                        }
                    }
                }
            }
            // println("while. end. queue $queue, visited $visited")
        }

        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1 && !visited.contains(i to j)) {
                    return -1
                }
            }
        }

        return res
    }
}
