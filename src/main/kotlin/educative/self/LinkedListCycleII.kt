package educative.self

// https://leetcode.com/problems/linked-list-cycle-ii/description/
class LinkedListCycleII {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var l = head
        var f = head
        while (f?.next != null) {
            f = f?.next?.next
            l = l?.next
            if (f == null) {
                return null
            }

            if (f == l) {
                break
            }
        }

        f = head
        while (f != l) {
            f = f?.next
            l = l?.next
        }

        return l
    }
}
