package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedListNode;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        if (head == null) return null;

        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
