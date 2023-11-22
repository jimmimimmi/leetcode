package educative.self

// https://leetcode.com/problems/number-of-islands/description/
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        val visited = HashSet<Pair<Int,Int>>()
        val neighbours = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
        var result = 0

        for(i in 0 until grid.size){
            for(j in 0 until grid[0].size){
                if (grid[i][j]=='0') continue

                val cellPair = i to j
                if (visited.contains(cellPair)) continue

                result++
                val queue = ArrayDeque<Pair<Int,Int>>()
                queue.addLast(cellPair)
                //println("start queue at $cellPair. visited: $visited")
                while(queue.isNotEmpty()){
                    val currCellPair = queue.removeFirst()
                    if (visited.contains(currCellPair)) continue
                    //println("\nStart dequeueing $currCellPair. queue: $queue, visited: $visited")
                    visited.add(currCellPair)
                    neighbours.forEach {
                        val nRow = currCellPair.first + it.first
                        val nCol = currCellPair.second + it.second

                        if (nRow>=0 && nRow < grid.size && nCol >= 0 && nCol < grid[0].size){
                            if (grid[nRow][nCol] != '0' && !visited.contains(nRow to nCol)) {
                                queue.addLast(nRow to nCol)
                            }
                        }
                    }

                    //println("End dequeueing $currCellPair. queue: $queue, visited: $visited")
                }
            }
        }

        return result
    }
}
