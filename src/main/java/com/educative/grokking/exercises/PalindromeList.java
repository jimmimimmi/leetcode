package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedListNode;

public class PalindromeList {
    public static <T> boolean palindrome(LinkedListNode<T> head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var current = slow;
        LinkedListNode<T> prev = null;
        LinkedListNode<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        var left = head;
        var right = prev;
        while (right != null){
            if (!left.data.equals(right.data)) {
                return false;
            }
            left = left.next;
            right = right.next;
        }


        return true;
    }
}

