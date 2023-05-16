package com.educative.grokking.exercises;

import java.util.PriorityQueue;

/*
Given an infinite stream of integers, nums, design a class to find the kth largest element in a stream.
 */
public class KthLargestElementinaStream {
    private final int k;
    private final PriorityQueue<Integer> heap;
    // constructor to initialize topKHeap and add values in it

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    // adds element in the topKHeap
    public int add(int val) {
        heap.offer(val);
        while (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }

    // returns kth largest element from topKHeap
    public int returnKthLargest() {
        // Your code will replace this placeholder return statement

        return heap.peek();
    }
}
