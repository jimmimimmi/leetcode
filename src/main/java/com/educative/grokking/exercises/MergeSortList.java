package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedList;
import com.educative.grokking.templates.LinkedListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortList {
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {

        var head = new LinkedListNode(1);
        LinkedListNode curr = head;
        var heap = new PriorityQueue<LinkedListNode>(Comparator.comparingInt(o -> (int) o.data));

        for (int i = 0; i < lists.size(); i++) {
            heap.offer(lists.get(i).head);
        }

        while (!heap.isEmpty()) {
            var heapHead = heap.poll();
            curr.next = heapHead;
            curr = heapHead;
            if (heapHead.next != null) {
                heap.offer(heapHead.next);
            }
        }

        return head.next;
    }

    public static LinkedListNode mergeKListsWithoutExtraMemory(List<LinkedList> lists) {

        while (lists.size() != 1) {
            var idx = 0;
            while (idx < lists.size() - 1) {
                var left = lists.get(idx).head;
                var right = lists.get(idx + 1).head;
                var mergedHead = mergeTwoSortedLists(left, right);
                lists.get(idx).head = mergedHead;
                lists.remove(idx + 1);
                idx++;
            }
        }
        return lists.get(0).head;
    }

    private static LinkedListNode mergeTwoSortedLists(LinkedListNode head1, LinkedListNode head2) {
        var head = new LinkedListNode(-1);
        var current = head;

        var left = head1;
        var right = head2;

        while (left != null || right != null) {
            if (left == null) {
                current.next = right;
                current = right;
                right = right.next;
            } else if (right == null) {
                current.next = left;
                current = left;
                left = left.next;
            } else if ((int) left.data <= (int) right.data) {
                current.next = left;
                current = left;
                left = left.next;
            } else {
                current.next = right;
                current = right;
                right = right.next;
            }
        }
        return head.next;
    }
}
