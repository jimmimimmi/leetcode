package com.educative.grokking.exercises;

// https://leetcode.com/problems/palindrome-permutation/
public class PalindromePermutation {
    public static boolean permutePalindrome(String st) {
        if (st == null || st.length() == 0) {
            return false;
        }
        if (st.length() == 1) {
            return true;
        }

        var counts = new int[26];
        for (var ch : st.toCharArray()) {
            counts[ch - 'a']++;
        }

        var oddChar = '.';
        for (var i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0 && oddChar != '.') {
                return false;
            }
            if (counts[i] % 2 != 0){
                oddChar = (char) (i + 'a');
            }
        }
        return true;
    }
}
