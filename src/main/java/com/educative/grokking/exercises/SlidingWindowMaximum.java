package com.educative.grokking.exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static List<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
        int maxWindowSize = Math.min(nums.size(), windowSize);
        var results = new ArrayList<Integer>();
        var decreasingDeque = new ArrayDeque<Integer>();

        for (int i = 0; i < nums.size(); i++) {
            while (!decreasingDeque.isEmpty() && nums.get(decreasingDeque.peekLast()) <= nums.get(i)) {
                decreasingDeque.removeLast();
            }
            if (i >= maxWindowSize &&
                    !decreasingDeque.isEmpty() &&
                    decreasingDeque.peekFirst() <= i - windowSize) {
                decreasingDeque.removeFirst();
            }

            decreasingDeque.addLast(i);
            if (i >= maxWindowSize - 1) {
                results.add(nums.get(decreasingDeque.peekFirst()));
            }
        }

        return results;
    }
}