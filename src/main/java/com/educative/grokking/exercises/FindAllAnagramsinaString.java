package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagramsinaString {

    private static boolean areArrsEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> findAnagrams(String a, String b) {

        if (b.length() > a.length()) {
            return new ArrayList<>();
        }

        var bCount = new int[26];
        for (var c : b.toCharArray()) {
            bCount[c - 'a']++;
        }
        var sbb = new StringBuilder();
        for (var bNum : bCount) {
            sbb.append(bNum);
            sbb.append(',');
        }
        var bStr = sbb.toString();

        var aCount = new int[26];
        for (int i = 0; i < b.length(); i++) {
            aCount[a.charAt(i) - 'a']++;
        }


        var res = new ArrayList<Integer>();
        if (areArrsEqual(aCount, bCount)) {
            res.add(0);
        }

        // abab, ab
        for (var i = 1; i + b.length() <= a.length(); i++) {
            aCount[a.charAt(i - 1) - 'a']--;
            aCount[a.charAt(i + b.length() - 1) - 'a']++;

            if (areArrsEqual(aCount, bCount)) {
                res.add(i);
            }
        }
        return res;
    }
}
