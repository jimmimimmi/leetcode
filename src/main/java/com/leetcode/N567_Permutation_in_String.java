package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
567. Permutation in String
Medium
9.5K
305
company
Yandex
company
Amazon
company
Microsoft
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class N567_Permutation_in_String {
    // create a hashmap M1 based on s1. key - char, value - count of all such chars
    // create a sliding window and move forward along to s2
    // build the same hashmap for each window and compare with the M1,
    // if they equal then return true otherwise continue
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length())
            return false;

        var s1Counts = new int[26];
        var windowCounts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
        }


        var left = 0;
        var right = left + s1.length();
        var next = false;
        while (right <= s2.length()) {
            next = false;
            Arrays.fill(windowCounts, 0);
            for (int i = left; i < right; i++) {
                windowCounts[s2.charAt(i) - 'a']++;
            }

            for (int i = left; i < right; i++) {
                if (windowCounts[s2.charAt(i) - 'a'] != s1Counts[s2.charAt(i) - 'a']) {
                    next = true;
                    break;
                }
            }
            if (next) {
                left++;
                right++;
            } else {
                return true;
            }

        }
        return false;
    }

    public boolean checkInclusionBetterPerformance(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length())
            return false;

        var s1Counts = new int[26];
        var windowCounts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
        }


        var left = 0;
        var right = left + s1.length();
        var next = false;
        while (right <= s2.length()) {
            next = false;
            Arrays.fill(windowCounts, 0);
            for (int i = left; i < right; i++) {
                windowCounts[s2.charAt(i) - 'a']++;
            }

            for (int i = left; i < right; i++) {
                if (windowCounts[s2.charAt(i) - 'a'] != s1Counts[s2.charAt(i) - 'a']) {
                    next = true;
                    break;
                }
            }
            if (next) {
                left++;
                right++;
            } else {
                return true;
            }

        }
        return false;
    }
}
