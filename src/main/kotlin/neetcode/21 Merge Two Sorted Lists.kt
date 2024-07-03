package neetcode

// 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/description/
class `21 Merge Two Sorted Lists` {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l = list1
        var r = list2

        var head = ListNode(0)
        var cur = head
        while (l != null && r != null) {
            if (l.`val` <= r.`val`) {
                cur.next = l
                cur = l
                l = l.next
            } else {
                cur.next = r
                cur = r
                r = r.next
            }
        }
        if (l != null) {
            cur.next = l
            cur = cur.next
        }
        if (r != null) {
            cur.next = r
            cur = cur.next
        }
        return head.next
    }
}