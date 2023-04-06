package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedListNode;

public class ReverseNodesInKGroup {
    public static LinkedListNode reverseLinkedList(LinkedListNode head, int k) {
        LinkedListNode prev = null;
        LinkedListNode prevLeft = null;
        var currLeft = head;
        var currRight = head;

        while (currRight != null) {
            for (int i = 1; i < k && currRight != null; i++) {
                currRight = currRight.next;
            }
            if (currRight != null) {
                var next = currRight.next;
                reverse(prev, currLeft, currRight);
                if (prev == null) {
                    head = currRight;
                }
                if (prevLeft != null) {
                    prevLeft.next = currRight;
                }
                prevLeft = currLeft;
                prev = currRight;

                currLeft.next = next;
                currLeft = next;
                currRight = next;
            }
        }

        return head;
    }
    private static void reverse(LinkedListNode prev, LinkedListNode left, LinkedListNode right) {
        var current = left;
        var previous = prev;
        var next = left;
        var stop = right.next;
        while (current != stop) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }
}
