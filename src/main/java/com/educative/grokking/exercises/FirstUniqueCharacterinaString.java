package com.educative.grokking.exercises;

import java.util.HashMap;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/
public class FirstUniqueCharacterinaString {

    public static int firstUniqueChar(String s) {

        if (s == null || s.isEmpty()) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        var count = new int[26];
        for (var c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
