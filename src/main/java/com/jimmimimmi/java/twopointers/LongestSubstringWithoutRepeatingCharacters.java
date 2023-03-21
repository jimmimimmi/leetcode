package com.jimmimimmi.java.twopointers;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/articles/longest-substring-without-repeating-characters/
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int result = 0;
        int left = 0;
        int right = 0;

        var lastIndexes = new HashMap<Character, Integer>();
        while (right < s.length()) {
            var c = s.charAt(right);
            var prevIndex = lastIndexes.get(c);
            if (prevIndex != null && prevIndex >= left) {
                left = prevIndex + 1;
            }

            lastIndexes.put(c, right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
