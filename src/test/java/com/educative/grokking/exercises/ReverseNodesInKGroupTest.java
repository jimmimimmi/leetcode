package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedList;
import com.educative.grokking.templates.LinkedListNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

public class ReverseNodesInKGroupTest extends TestCase {

    public void testReverseLinkedList() {
        System.out.println(LinkedList.printList(ReverseNodesInKGroup.reverseLinkedList(LinkedList.createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6, 7}).head, 3)));
    }
}