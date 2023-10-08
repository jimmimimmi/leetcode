package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<ArrayList<Integer>, List<String>>();

        for (var s : strs) {
            var counts = new ArrayList<Integer>();
            for (int i = 0; i < 26; i++) {
                counts.add(0);
            }

            for (var c : s.toCharArray()) {
                counts.set(c - 'a', counts.get(c - 'a') + 1);
            }


            map.computeIfAbsent(counts, k -> new ArrayList<>()).add(s);
        }

        var result = new ArrayList<List<String>>();
        for (var e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}
