package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedList;
import junit.framework.TestCase;

public class ReorderListTest extends TestCase {

    public void testReorderList() {
        System.out.println(LinkedList.printList(ReorderList.reorderList(LinkedList.createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6, 7}).head)));

    }
}