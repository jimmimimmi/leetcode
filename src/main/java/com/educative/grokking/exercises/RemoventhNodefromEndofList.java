package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedListNode;

public class RemoventhNodefromEndofList {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {

        if (head == null) return null;
        var left = head;
        var right = head;
        LinkedListNode  prev = null;
        for (int i = 0; i < n; i++) {
            if (right == null) {
                break;
            }
            right = right.next;
        }
        while (right != null){
            prev = left;
            right = right.next;
            left = left.next;
        }
        if (prev == null) {
            return head.next;
        }
        prev.next = left.next;

        return head;
    }
}
