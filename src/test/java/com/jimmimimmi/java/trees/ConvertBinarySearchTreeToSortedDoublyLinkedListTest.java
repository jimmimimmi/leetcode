package com.jimmimimmi.java.trees;

import junit.framework.TestCase;

public class ConvertBinarySearchTreeToSortedDoublyLinkedListTest extends TestCase {

    public void testTreeToDoublyList() {
        new ConvertBinarySearchTreeToSortedDoublyLinkedList()
                .treeToDoublyList(
                        BinarySearchFactory.Create(new Integer[]{27, -99, 55, null, -34, null, 58, null, -8, null, 59, null, 8, null, 68}));
    }
}