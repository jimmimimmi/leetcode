package com.educative.grokking.exercises;

import java.util.HashMap;

// https://leetcode.com/problems/longest-palindrome/description/
public class LongestPalindrome {
    public static int longestPalindrome(String palString) {

        if (palString == null || palString.length() == 0) {
            return 0;
        }
        if (palString.length() == 1) {
            return 1;
        }

        var counts = new int[60];
        for (var c : palString.toCharArray()) {
            counts[c - 'A']++;
        }
        var maxOddNumber = 0;
        Character oddChar = null;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 != 0) {
                if (counts[i] > maxOddNumber) {
                    maxOddNumber = counts[i];
                    oddChar = (char) (i + 'A');
                }
            }
        }

        var evenOptions = 0;

        for (int i = 0; i < counts.length; i++) {
            var ch = (char) (i + 'A');
            if (oddChar == null || !oddChar.equals(ch)){
                evenOptions += (counts[i] / 2) * 2;
            }
        }

        return maxOddNumber + evenOptions;
    }
}
