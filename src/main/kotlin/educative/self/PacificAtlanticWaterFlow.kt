package educative.self

public class PacificAtlanticWaterFlow {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val down = HashSet<Pair<Int, Int>>()
        for (i in 0 until heights[0].size) {
            down.add(heights.size - 1 to i)
        }

        for (i in heights.size - 2 downTo 0) {
            for (j in 0 until heights[0].size) {
                if (heights[i][j] > heights[i + 1][j] && down.contains(i + 1 to j)) {
                    down.add(i to j)
                }
            }
        }

        val up = HashSet<Pair<Int, Int>>()
        for (i in 0 until heights[0].size) {
            up.add(0 to i)
        }

        for (i in 1 until heights.size) {
            for (j in 0 until heights[0].size) {
                if (heights[i][j] > heights[i - 1][j] && up.contains(i - 1 to j)) {
                    up.add(i to j)
                }
            }
        }

        val right = HashSet<Pair<Int, Int>>()
        for (i in 0 until heights.size) {
            right.add(i to heights[0].size - 1)
        }

        for (i in 0 until heights.size) {
            for (j in heights[0].size - 2 downTo 0) {
                if (heights[i][j] > heights[i][j + 1] && right.contains(i to j + 1)) {
                    right.add(i to j)
                }
            }
        }

        val left = HashSet<Pair<Int, Int>>()
        for (i in 0 until heights.size) {
            left.add(i to 0)
        }

        for (i in 0 until heights.size) {
            for (j in 1 until heights[0].size) {
                if (heights[i][j] > heights[i][j - 1] && left.contains(i to j - 1)) {
                    left.add(i to j)
                }
            }
        }

        val atlantic = down.union(right)
        val pacific = left.union(up)

        val result = atlantic.intersect(pacific)

        return result.toList().map { listOf(it.first, it.second) }
    }
}

/*

create in kotlin a loops

```
for (int i = 0; i <= 100; i+=3) {}
```

```
for (int i = 1000; i >= 0; i-=3) {}
```

 */
