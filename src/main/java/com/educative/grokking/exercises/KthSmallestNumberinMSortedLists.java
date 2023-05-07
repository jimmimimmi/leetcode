package com.educative.grokking.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberinMSortedLists {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        var result = 0;
        var currentNum = 0;
        for (int i = 0; i < lists.size(); i++) {
            var list = lists.get(i);
            if (list.size() > 0) {
                minHeap.offer(new int[]{list.get(0), i, 0});
            }
        }

        while (currentNum < k && !minHeap.isEmpty()) {
            var min = minHeap.poll();
            result = min[0];
            var listIdx = min[1];
            var elementIdx = min[2];
            currentNum++;
            if (currentNum == k) {
                return result;
            }
            var list = lists.get(listIdx);
            if (list.size() > elementIdx + 1) {
                minHeap.offer(new int[]{list.get(elementIdx + 1), listIdx, elementIdx + 1});
            }
        }

        return result;
    }
}
