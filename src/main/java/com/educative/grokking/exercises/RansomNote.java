package com.educative.grokking.exercises;

// https://leetcode.com/problems/ransom-note/submissions/
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null || magazine == null) {
            return false;
        }
        var ransomCount = new int[26];
        for (var c : ransomNote.toCharArray()) {
            ransomCount[c - 'a']++;
        }

        var magazineCount = new int[26];
        for (var c : magazine.toCharArray()) {
            magazineCount[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (ransomCount[i] > magazineCount[i]) {
                return false;
            }
        }

        return true;
    }
}
