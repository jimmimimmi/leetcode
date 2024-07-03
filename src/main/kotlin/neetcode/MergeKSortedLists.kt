package neetcode

import java.util.*

// 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/description/
class MergeKSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode> { a, b -> a.`val`.compareTo(b.`val`) }

        lists.forEach { n ->
            if (n != null) {
                queue.add(n)
            }
        }

        val fakeNode = ListNode(0)
        var cur: ListNode? = fakeNode
        while (queue.isNotEmpty()) {
            val node = queue.poll()!!
            cur!!.next = node
            cur = node
            if (cur.next != null) {
                queue.add(cur.next)
            }
        }

        return fakeNode.next
    }
}