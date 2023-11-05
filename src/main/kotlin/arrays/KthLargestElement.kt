package arrays

import java.util.PriorityQueue

// https://leetcode.com/problems/kth-largest-element-in-an-array/
class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        /*
            1 8 2 6 3 9 5, 3

        PriorQueue[3]: 6,8,9


         */
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.addAll(nums.take(k))
        nums.drop(k).forEach {
            priorityQueue.add(it)
            priorityQueue.poll()
        }

        return priorityQueue.poll()
    }
}
