package educative.self

import java.util.*
import kotlin.math.*

class MinMeetingRooms {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.size == 1) {
            return 1
        }
        var res = 0
        val sorted = intervals.sortedBy { it[0] }
        val queue = PriorityQueue<IntArray> { a, b -> a[1].compareTo(b[1]) }

        sorted.forEach {
            while (queue.isNotEmpty() && queue.peek()[1] <= it[0]) {
                queue.poll()
            }
            queue.offer(it)
            res = max(res, queue.size)
        }

        return res
    }
}
