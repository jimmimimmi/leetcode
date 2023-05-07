package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        var larger = new PriorityQueue<Integer>();
        var smaller = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2, o1));

        for (var i = 0; i < k; i++) {
            smaller.offer(nums[i]);
        }

        for (var i = 0; i < k / 2; i++) {
            larger.offer(smaller.poll());
        }

        var results = new ArrayList<Double>();

        if (k % 2 == 1) {
            results.add((double) smaller.peek());
        } else {
            results.add(smaller.peek() / 2.0 + larger.peek() / 2.0);
        }

        var outgoingNumbersToCount = new HashMap<Integer, Integer>();
        var incomingIdx = k;
        while (incomingIdx < nums.length) {
            var outgoingIdx = incomingIdx - k;
            var outgoingEl = nums[outgoingIdx];
            var incomingEl = nums[incomingIdx];
            incomingIdx++;

            var balance = 0;
            if (outgoingEl <= smaller.peek()) {
                balance--;
            } else {
                balance++;
            }

            if (incomingEl <= smaller.peek()) {
                balance++;
                smaller.offer(incomingEl);
            } else {
                balance--;
                larger.offer(incomingEl);
            }

            outgoingNumbersToCount.compute(outgoingEl, (key, val) -> val == null ? 1 : val + 1);

            if (balance < 0) {
                smaller.offer(larger.poll());
            } else if (balance > 0) {
                larger.offer(smaller.poll());
            }

            while (!smaller.isEmpty() && outgoingNumbersToCount.containsKey(smaller.peek()) && outgoingNumbersToCount.get(smaller.peek()) > 0) {
                outgoingNumbersToCount.compute(smaller.poll(), (key, val) -> val == null ? null : val - 1);
            }

            while (!larger.isEmpty() && outgoingNumbersToCount.containsKey(larger.peek()) && outgoingNumbersToCount.get(larger.peek()) > 0) {
                outgoingNumbersToCount.compute(larger.poll(), (key, val) -> val == null ? null : val - 1);
            }

            if (k % 2 == 1) {
                results.add((double) smaller.peek());
            } else {
                results.add(smaller.peek() / 2.0 + larger.peek() / 2.0);
            }

        }

        return results.stream().mapToDouble(v -> v).toArray();
    }
}
