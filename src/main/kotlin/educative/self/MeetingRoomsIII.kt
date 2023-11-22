package educative.self

import java.util.*
import kotlin.math.max

// https://leetcode.com/problems/meeting-rooms-iii/description/
class MeetingRoomsIII {
    /*
       -----------
        -----
         ------
          --

       n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]


       {0, 0-10}
       {1, 1-5}


       [2,7] -> [5,10]
       {0, 0-10}
       {1, 5-10}

       [3,4] -> [10,11]
       {0, 10-11}
       {1, 5-10}

       =================================

       n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]

       {1, 1-20}
       {2, 2-10}
       {3, 3-5}

       [4,9] -> [5,10]

       {1, 1-20}
       {2, 2-10}
       {3, 5-10}

       [6,8]->[10,12]
       {1, 1-20}
       {2, 10-12}
       {3, 5-10}

       ============================




        */
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val ss = queue.removeLast()

        val visited = HashSet<Pair<Int,Int>>()

        visited.contains(1 to 2)
        if (meetings.size == 1) {
            return 0
        }

        val earliestEndTimeQueue = PriorityQueue<Pair<Long, Int>> { a, b ->
            if (a.first != b.first) {
                a.first.compareTo(b.first)
            } else {
                a.second.compareTo(b.second)
            }
        }

        val freeRooms = PriorityQueue<Int>()
        for (i in 0 until n) {
            freeRooms.offer(i)
        }

        val roomUsages = LongArray(n) { 0 }
        val sorted = meetings.sortedBy { it[0] }

        sorted.forEach {
            val start = it[0].toLong()
            val end = it[1].toLong()

            while (earliestEndTimeQueue.isNotEmpty() && earliestEndTimeQueue.peek().first <= start) {
                val roomNum = earliestEndTimeQueue.poll().second
                freeRooms.offer(roomNum)
            }

            if (freeRooms.isNotEmpty()) {
                val roomNum = freeRooms.poll()
                roomUsages[roomNum]++
                earliestEndTimeQueue.offer(end to roomNum)
            } else {
                val head = earliestEndTimeQueue.poll()
                val headEndTime = head.first
                val headNum = head.second
                roomUsages[headNum]++

                val headNextEndTime = max(headEndTime, start) + (end - start)

                earliestEndTimeQueue.offer(headNextEndTime to headNum)
            }
        }

        return roomUsages.indexOf(roomUsages.max())
    }
}
