package com.educative.grokking.exercises;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
Given a string, rearrange it so that any two adjacent characters are not the same.
If such a reorganization of the characters is possible, output any possible valid arrangement.
Otherwise, return an empty string.
 */
public class ReorganizeString {
    public static String reorganizeString(String string1) {

        var freqMap = new HashMap<Character, Integer>();
        for (Character c : string1.toCharArray()) {
            var prevFreq = freqMap.get(c);
            freqMap.put(c, prevFreq == null ? 1 : prevFreq + 1);
        }
        var heap = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        freqMap.forEach((character, freq) -> heap.offer(new int[]{freq, character}));

        var result = new StringBuilder();
        while (!heap.isEmpty()) {
            var head = heap.poll();
            var headFreq = head[0];
            char headChar = (char) head[1];
            result.append(headChar);
            if (headFreq == 1) continue;
            if (heap.isEmpty()) {
                return "";
            }

            var nextHead = heap.poll();
            var nextHeadFreq = nextHead[0];
            char nextHeadChar = (char) nextHead[1];
            result.append(nextHeadChar);
            if (headFreq > 1) {
                heap.offer(new int[]{headFreq - 1, headChar});
            }
            if (nextHeadFreq > 1) {
                heap.offer(new int[]{nextHeadFreq - 1, nextHeadChar});
            }
        }

        return result.toString();
    }
}
