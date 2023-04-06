package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedListNode;

public class ReverseNodesInEvenLengthGroups {
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var curLength = 2;
        var prevEnd = head;
        var left = head.next;
        var right = head.next;

        while (right != null) {
            var actualLength = 1;
            for (var i = 1; i < curLength && right.next != null; i++) {
                actualLength ++;
                right = right.next;
            }
            var rightNext = right.next;
            if (actualLength % 2 == 0) {
                var cur = left;
                var prev = prevEnd;

                while (cur != rightNext) {
                    var next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }

                left.next = rightNext;
                prevEnd.next = prev;
                prevEnd = left;
            } else {
                prevEnd = right;
            }

            curLength++;
            right = rightNext;
            left = rightNext;
        }

        // Write your code here
        return head;
    }
}
