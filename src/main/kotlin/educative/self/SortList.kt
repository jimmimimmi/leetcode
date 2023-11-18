package educative.self

class SortList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun split(head: ListNode?): Pair<ListNode?, ListNode?> {
        if (head?.next == null) {
            return head to null
        }
        var first = head
        var second = head
        var previous: ListNode? = null
        while (second?.next != null) {
            previous = first
            first = first?.next
            second = second?.next?.next
        }

        if (previous != null) {
            previous.next = null
        }

        return head to first
    }

    // [1,4] [2,3]
    private fun merge(left: ListNode?, right: ListNode?): ListNode? {
        val head = ListNode(-1)
        var tail: ListNode? = null

        var curLeft = left
        var curRight = right

        while (curLeft != null && curRight != null) {
            val minNode = if (curLeft.`val` <= curRight.`val`) {
                val temp = curLeft
                curLeft = curLeft.next
                temp
            } else {
                val temp = curRight
                curRight = curRight.next
                temp
            }

            if (tail == null) {
                tail = minNode
                head.next = tail
            } else {
                tail.next = minNode
                tail = minNode
            }
        }

        if (curLeft != null) {
            if (tail == null) {
                tail = curLeft
                head.next = tail
            } else {
                tail.next = curLeft
            }
        }

        if (curRight != null) {
            if (tail == null) {
                tail = curRight
                head.next = tail
            } else {
                tail.next = curRight
            }
        }

        return head.next
    }

    // [4,2,1,3]
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val (left, right) = split(head)
        val leftSorted = sortList(left)
        val rightSorted = sortList(right)
        val result = merge(leftSorted, rightSorted)

        return result
    }
}
