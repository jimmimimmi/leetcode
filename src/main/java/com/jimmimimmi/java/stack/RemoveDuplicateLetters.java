package com.jimmimimmi.java.stack;

import java.util.Stack;
//https://leetcode.com/problems/remove-duplicate-letters/
/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;
        var lastOccurrences = new int[26];
        var currentSolution = new boolean[26];
        var stackSolution = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrences[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            var charAsInt = s.charAt(i) - 'a';
            if (currentSolution[charAsInt]) continue;
            while (!stackSolution.isEmpty() &&
                    stackSolution.peek() > charAsInt &&
                    lastOccurrences[stackSolution.peek()] > i) {
                var pop = stackSolution.pop();
                currentSolution[pop] = false;
            }
            stackSolution.push(charAsInt);
            currentSolution[charAsInt] = true;
        }

        StringBuilder result = new StringBuilder();
        while (!stackSolution.isEmpty()) {
            result.insert(0, (char) (stackSolution.pop() + 'a'));
        }
        return result.toString();
    }
}
