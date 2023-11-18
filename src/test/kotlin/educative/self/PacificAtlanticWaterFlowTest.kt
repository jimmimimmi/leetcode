package educative.self

import junit.framework.TestCase

class PacificAtlanticWaterFlowTest : TestCase() {

    fun testPacificAtlantic() {
        PacificAtlanticWaterFlow().pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4),
            ),
        )
    }
}
