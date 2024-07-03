package neetcode

// https://leetcode.com/problems/reorder-list/description/
// 143. Reorder List

class ReorderLinkedList {
    class ListNode(var `val`: Int) {
            var next: ListNode? = null
    }
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head!!.next == null) return

        var slow = head
        var fast = head

        while (fast?.next?.next != null){
            slow = slow!!.next
            fast = fast!!.next!!.next
        }

        // println("1. head " + printList(head))
        // println("1.1 slow " + printList(slow))
        // println("1.2 fast " + printList(fast))

        var cur = slow!!.next
        slow!!.next = null
        slow = cur
        cur = null

        // println("2. head " + printList(head))
        // println("2.1 slow " + printList(slow))
        // println("2.2 fast " + printList(fast))

        while(slow != null){
            val next = slow.next
            slow.next = cur
            cur = slow
            slow = next
        }

        // println("3. head " + printList(head))



        var l = head
        var r = cur
        cur = ListNode(0)
        var head2 = cur

        // println("4.1. l " + printList(l))
        // println("4.2. r " + printList(r))
        while (l != null && r != null){

            cur!!.next = l
            cur = l
            l = l.next

            cur.next = r
            cur = r
            r = r.next

            // println("5.1. head " + printList(head))
            // println("5.2. head2 " + printList(head2))
        }

        if (l != null) {
            cur!!.next = l
        }

        if (r != null) {
            cur!!.next = r
        }

        // println("6.1. head " + printList(head))
    }
}