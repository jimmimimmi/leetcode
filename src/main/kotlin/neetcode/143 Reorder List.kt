package neetcode

// 143. Reorder List
// https://leetcode.com/problems/reorder-list/description/
class `143 Reorder List` {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reorderList(head: ListNode?): Unit {
        if (head == null || head!!.next == null) return
        var slow = head
        var fast = head

        while (fast?.next?.next != null) {
            slow = slow!!.next
            fast = fast!!.next!!.next
        }

        var cur = slow!!.next
        slow!!.next = null
        slow = cur
        cur = null

        while (slow != null) {
            val next = slow.next
            slow.next = cur
            cur = slow
            slow = next
        }

        var l = head
        var r = cur
        cur = ListNode(0)

        while (l != null && r != null) {
            cur!!.next = l
            cur = l
            l = l.next
            cur.next = r
            cur = r
            r = r.next
        }

        if (l != null) { cur!!.next = l }
        if (r != null) { cur!!.next = r }
    }
}