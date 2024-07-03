package neetcode

// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
class `206 Reverse Linked List` {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var cur = head!!
        var next = cur.next
        while (next != null) {
            val nextNext = next.next
            next.next = cur
            if (cur == head) {
                cur.next = null
            }
            cur = next
            next = nextNext
        }
        return cur
    }
}