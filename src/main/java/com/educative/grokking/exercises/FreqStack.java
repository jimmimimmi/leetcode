package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/maximum-frequency-stack/description/
public class FreqStack {
    private HashMap<Integer, Integer> valueToFreq = new HashMap<>();
    private HashMap<Integer, Stack<Integer>> freqToElements = new HashMap<>();
    private int maxFreq = 0;

    public FreqStack() {

    }

    public void push(int val) {
        var freq = valueToFreq.getOrDefault(val, 0);
        var newFreq = freq + 1;
        valueToFreq.put(val, newFreq);
        if (maxFreq < newFreq) {
            maxFreq = newFreq;
        }
        var stack = freqToElements.computeIfAbsent(newFreq, k -> new Stack<>());
        stack.push(val);
    }

    public int pop() {
        if (maxFreq <= 0) {
            return -1;
        }

        var res = freqToElements.get(maxFreq).pop();
        valueToFreq.put(res, maxFreq - 1);
        if (freqToElements.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return res;

    }

}
