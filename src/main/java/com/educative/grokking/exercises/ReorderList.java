package com.educative.grokking.exercises;

/*

Given the head of a singly linked list, reorder the list as if it were folded on itself.
For example, if the list is represented as follows:

          s    s
                    f       f
1 -> 2 -> 3 -> 4 -> 5 -> 6  => 1 -> 6 -> 2 -> 5 -> 3 -> 4

1 -> 2 -> 3 -> 4 -> 5   => 1 -> 5 -> 2 -> 4 -> 3


 */

import com.educative.grokking.templates.LinkedListNode;

public class ReorderList {
    public static LinkedListNode reorderList(LinkedListNode head) {
        if(head == null)
            return head;
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        LinkedListNode prev = null;
        var cur = slow;
        while (cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        var list1Cur = head;
        var list2Cur = prev;

        cur = head;
        // 1->2->3,  6->5->4

        while (list2Cur.next != null) {
            cur = cur.next; //2
            list1Cur.next = list2Cur; // 1 -> 6
            list2Cur = list2Cur.next; // 5
            list1Cur.next.next = cur; // 1 -> 6 -> 2
            list1Cur = list1Cur.next.next; // 2
        }

        return head;
    }

}
