package com.educative.grokking.exercises;

import java.util.HashMap;

/*
Given a string,
inputString find the longest substring without repeating characters,
and return the length of that longest substring.


aaaaaaa -> 1

axybcdbdetyr-> 4


 */
public class LongestSubstring {
    public static int findLongestSubstring(String inputString) {
        var lastOccurrenceMap = new HashMap<Character, Integer>();
        var left = 0;
        var right = 0;
        int result = 0;
        while (right < inputString.length()) {
            var rightChar = inputString.charAt(right);
            var windowLength = right - left + 1;

            if (lastOccurrenceMap.containsKey(rightChar)) {
                var prevIndex = lastOccurrenceMap.get(rightChar);
                if (prevIndex >= left) {
                    windowLength = right - left;
                    left = prevIndex + 1;
                    lastOccurrenceMap.put(rightChar, right);
                }
            }

            result = Math.max(windowLength, result);

            lastOccurrenceMap.put(rightChar, right);
            right++;
        }
        // your code will replace this placeholder return statement

        return result;
    }
}
