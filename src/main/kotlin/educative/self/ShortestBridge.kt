package educative.self

// https://leetcode.com/problems/shortest-bridge/
class ShortestBridge {
    private val neighbours = arrayOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1))

    fun shortestBridge(grid: Array<IntArray>): Int {
        val parents = (0 until 4).toList().toTypedArray()
        var nonZeroCell: Pair<Int, Int>? = null
        grid.forEachIndexed { rowIdx, ints ->
            ints.forEachIndexed { colIdx, i ->
                if (i != 0 && nonZeroCell == null) {
                    nonZeroCell = rowIdx to colIdx
                }
            }
        }

        val firstIsland = HashSet<Pair<Int, Int>>()

        dfsFindIsland(firstIsland, nonZeroCell!!, grid)

        var minDist: Int? = null

        val queue = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
        val visited = HashSet<Pair<Int, Int>>()

        firstIsland.forEach {
            queue.addLast(it to 0)
        }
        println("grid: ${grid.size}")

        while (queue.isNotEmpty()) {
            val (cell, dist) = queue.removeFirst()
            if (minDist != null && minDist < dist) {
                continue
            }
            val row = cell.first
            val col = cell.second
            if (visited.contains(cell)) {
                continue
            }
            visited.add(cell)

            if (grid[row][col] == 1 && !firstIsland.contains(cell)) {
                if (minDist == null || minDist > dist) {
                    minDist = dist
                }
            } else {
                neighbours.forEach {
                    val nextRow = row + it[0]
                    val nextCol = col + it[1]
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.size && nextCol < grid.size) {
                        val nextCell = nextRow to nextCol
                        if (!visited.contains(nextCell) && !firstIsland.contains(nextCell)) {
                            queue.addLast(nextCell to dist + 1)
                        }
                    }
                }
            }
        }

        return minDist!! - 1
    }

    private fun dfsFindIsland(islandCells: HashSet<Pair<Int, Int>>, currCell: Pair<Int, Int>, grid: Array<IntArray>) {
        if (islandCells.contains(currCell)) {
            return
        }
        islandCells.add(currCell)

        val curRow = currCell.first
        val curCol = currCell.second

        for (i in 0 until 4) {
            val nextRow = neighbours[i][0] + curRow
            val nextCol = neighbours[i][1] + curCol

            if (nextCol >= 0 && nextRow >= 0 && nextRow < grid.size && nextCol < grid.size) {
                if (grid[nextRow][nextCol] == 1) {
                    dfsFindIsland(islandCells, nextRow to nextCol, grid)
                }
            }
        }
    }
}
