package com.educative.grokking.templates;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LinkedList<T> {
    public LinkedListNode<T> head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public static <T> LinkedList<T> createLinkedList(T[] lst) {
        var head = new LinkedList<T>();
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(lst[i]);
            head.insertNodeAtHead(newNode);
        }
        return head;
    }

    public static <T> String printList(LinkedListNode<T> head){
        var ts = new ArrayList<T>();
        var cur = head;
        while (cur != null) {
            ts.add(cur.data);
            cur = cur.next;
        }
        return ts.stream().map(Object::toString).collect(Collectors.joining(" -> "));
    }

}
