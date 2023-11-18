package educative.self

// https://leetcode.com/problems/non-overlapping-intervals/
class EraseOverlapIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size <= 1) {
            return 0
        }
        val sorted = intervals.sortedBy { it[0] }

        var remove = 0

        var currInterval = sorted[0]

        sorted.drop(1).forEach {
            if (currInterval[0] == it[0] || currInterval[1] > it[0]) {
                remove++
                if (currInterval[1] > it[1]) {
                    currInterval = it
                }
            } else {
                currInterval = it
            }
        }

        return remove
    }
}
