package com.educative.grokking.exercises;

import java.util.PriorityQueue;

public class MedianOfAStream {
    private PriorityQueue<Integer> largerQueue = new PriorityQueue<>(Integer::compare);
    private PriorityQueue<Integer> smallerQueue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));

    public MedianOfAStream() {
    }

    public void insertNum(int num) {
        if (smallerQueue.isEmpty() || smallerQueue.peek() >= num) {
            smallerQueue.offer(num);
        } else {
            largerQueue.offer(num);
        }

        if (smallerQueue.size() > largerQueue.size() + 1) {
            largerQueue.offer(smallerQueue.poll());
        } else if (largerQueue.size() > smallerQueue.size()) {
            smallerQueue.offer(largerQueue.poll());
        }
    }

    public double findMedian() {
        if (smallerQueue.size() == largerQueue.size()) {
            return (smallerQueue.peek() + largerQueue.peek()) / 2.0;
        }
        // Write your code here
        return smallerQueue.peek();
    }
}
