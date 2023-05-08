package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedList;
import com.educative.grokking.templates.LinkedListNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSortListTest extends TestCase {

    public void testMergeKListsWithoutExtraMemory() {
//        var list1 = MergeSortList.mergeKListsWithoutExtraMemory(new ArrayList<>(Arrays.asList(
//                LinkedList.createLinkedList(new Integer[]{21, 23, 42}),
//                LinkedList.createLinkedList(new Integer[]{1, 2, 4})
//        )));
//        var list2 = MergeSortList.mergeKListsWithoutExtraMemory(new ArrayList<>(Arrays.asList(
//                LinkedList.createLinkedList(new Integer[]{11, 41, 51}),
//                LinkedList.createLinkedList(new Integer[]{21, 23, 42})
//        )));
        var list3 = MergeSortList.mergeKListsWithoutExtraMemory(new ArrayList<>(Arrays.asList(
                LinkedList.createLinkedList(new Integer[]{2}),
                LinkedList.createLinkedList(new Integer[]{1, 2, 4}),
                LinkedList.createLinkedList(new Integer[]{25, 56, 66, 72})
        )));
        System.out.println(LinkedList.printList(list3));
    }
}