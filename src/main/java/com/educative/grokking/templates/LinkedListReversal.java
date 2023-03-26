package com.educative.grokking.templates;

class LinkedListReversal{
    static <T> LinkedListNode<T> reverseLinkedList(LinkedListNode<T> node){
        LinkedListNode<T> prev = null;
        LinkedListNode<T> current = node;
        LinkedListNode<T> next = null;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
