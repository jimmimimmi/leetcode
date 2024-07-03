package neetcode

// 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/description/
class LinkedListCycle {
     class ListNode(var `val`: Int) {
             var next: ListNode? = null
         }
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false
        var h1 = ListNode(0)
        var h2 = ListNode(0)

        h1.next = head
        h2.next = head

        var slow: ListNode? = h1
        var fast: ListNode? = h2

        while(fast != null){
            if (fast == slow) {
                return true
            }
            fast = fast?.next?.next
            slow = slow?.next
        }

        return false
    }
}
