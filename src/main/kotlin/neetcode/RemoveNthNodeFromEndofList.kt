package neetcode

// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
class RemoveNthNodeFromEndofList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        val fake = ListNode(0)
        fake.next = head

        var r: ListNode? = fake
        for (i in 1..n) {
            r = r!!.next
        }
        var l: ListNode? = fake

        while (r!!.next != null) {
            l = l!!.next
            r = r!!.next
        }

        val result = l!!.next
        l.next = result!!.next
        result.next = null

        return fake.next
    }
}