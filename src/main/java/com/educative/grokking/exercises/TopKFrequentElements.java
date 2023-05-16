package com.educative.grokking.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] arr, int k) {

        var freqMap = new HashMap<Integer, Integer>();
        for (var el : arr) {
            var prev = freqMap.get(el);
            freqMap.put(el, prev == null ? 1 : prev + 1);
        }
        var heap = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        var iterator = freqMap.entrySet().iterator();
        for (int j = 0; j < Math.min(k, freqMap.size()); j++) {
            var pair = iterator.next();
            heap.offer(new int[]{pair.getValue(), pair.getKey()});
        }

        while (iterator.hasNext()) {
            var pair = iterator.next();
            if (pair.getValue() > heap.peek()[0]) {
                heap.poll();
                heap.offer(new int[]{pair.getValue(), pair.getKey()});
            }
        }

        return heap.stream().map(o -> o[1]).collect(Collectors.toList());
    }
}
