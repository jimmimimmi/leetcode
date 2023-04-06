package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedListNode;

/*
You’re given the head of a singly linked list with n nodes
and two positive integers, left and right.
Our task is to reverse the list’s nodes from position left to position right and return the reversed list.
 */
public class ReverseLinkedListII {
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        LinkedListNode prev = null;

        var init = new LinkedListNode(1);
        init.next = head;
        var leftNode = init;
        var rightNode = init;

        for (var i = 1; i <= right; i++) {
            if (i <= left) {
                prev = leftNode;
                leftNode = leftNode.next;
            }
            rightNode = rightNode.next;
        }

        var cur = leftNode;
        var rightNext = rightNode.next;
        var curPrev = prev;
        while (cur != rightNext){
            var next = cur.next;
            if (curPrev != init) {
                cur.next = curPrev;
            } else {
                cur.next = null;
            }
            curPrev = cur;
            cur = next;
        }

        prev.next = rightNode;
        leftNode.next = rightNext;

        return init.next;
    }
}
