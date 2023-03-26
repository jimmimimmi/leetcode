package com.educative.grokking.templates;

public class LinkedListTraversal {
    public static <T> void traverseLinkedList(LinkedListNode<T> head){
        LinkedListNode<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
        }
    }
}

