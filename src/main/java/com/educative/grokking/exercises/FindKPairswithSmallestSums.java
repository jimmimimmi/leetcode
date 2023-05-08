package com.educative.grokking.exercises;

import java.util.*;

/*
Given two lists, and an integer k,
find k pairs of numbers with the smallest sum so that in each pair,
each list contributes one number to the pair.

Constraints:

Input lists should be sorted in ascending order.

If the value of k exceeds the total number of valid pairs that may be formed, return all the pairs.

 */
public class FindKPairswithSmallestSums {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(ar -> ar[0]));
        var result = new ArrayList<List<Integer>>();
        for (var i = 0; i < list1.length; i++){
            minHeap.offer(new int[]{list1[i] + list2[0], i, 0});
        }
        while (result.size() < target && !minHeap.isEmpty()) {
            var minHead = minHeap.poll();
            var i = minHead[1];
            var j = minHead[2];
            result.add(Arrays.asList(list1[i], list2[j]));
            if (j + 1 < list2.length){
                minHeap.offer(new int[]{list1[i] + list2[j + 1], i, j + 1});
            }
        }

        return result;
    }
}
