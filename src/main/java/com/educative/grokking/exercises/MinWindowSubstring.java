package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given two strings—s and t, find the smallest window substring of t.
The smallest window substring is the shortest sequence of characters in s
that includes all of the characters present in t.
The frequency of each character in this sequence should be greater than or equal to
the frequency of each character in t.

The order of the characters doesn’t matter here.
 */
public class MinWindowSubstring {
    // BACBABAD
    // DAA

    // D -> 1, A -> 2
    // A -> 3, D -> 1

    private static Map<Character, Long> countMap(String t1) {
        return t1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    }

    public static String minWindow(String s, String t) {
        var templateMap = countMap(t);
        var requiredBuckets = templateMap.size();
        var currentBuckets = 0;
        var currentWindowMap = new HashMap<Character, Long>();
        var left = 0;
        var right = 0;
        String result = null;
        while (right < s.length()) {
            var rightChar = s.charAt(right);
            right++;

            if (templateMap.containsKey(rightChar)) {
                currentWindowMap.compute(rightChar, (k, v) -> v == null ? 1L : v + 1);
                if (templateMap.get(rightChar).equals(currentWindowMap.get(rightChar))) {
                    currentBuckets++;
                }
            }

            while (currentBuckets == requiredBuckets) {
                if (templateMap.containsKey(s.charAt(left))) {
                    if (currentWindowMap.get(s.charAt(left)).equals(templateMap.get(s.charAt(left)))) {
                        currentBuckets--;
                        if (result == null || (right - (left)) < result.length()) {
                            result = s.substring(left, right);
                        }
                    }
                    currentWindowMap.computeIfPresent(s.charAt(left), (k, v) -> v - 1);
                }
                left++;
            }
        }

        return result;
    }

    public static String minWindowWithoutMapsComparing(String s, String t) {
        if (t.equals("")) {
            return "";
        }
        // Creating the two hash maps
        HashMap<Character, Integer> windowMap = new HashMap<>();
        HashMap<Character, Integer> templateMap = new HashMap<>();
        // Populating templateMap hashmap
        for (int i = 0; i < t.length(); i++) {
            var charI = t.charAt(i);
            templateMap.put(charI, templateMap.getOrDefault(charI, 0) + 1);
        }
        // Setting up the conditional variables
        int left = 0;
        int right = 0;
        int current = 0;
        int required = templateMap.size();


        String result = null;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            right++;
            // Populating the windowMap hashmap
            if (templateMap.containsKey(currentChar)) {
                windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

                if (windowMap.get(currentChar).equals(templateMap.get(currentChar))) {
                    current++;
                }
            }

            // Adjusting the sliding windowMap
            while (current == required) {
                // update our result
                if (result == null || right - left < result.length()) {
                    result = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                left++;

                if (templateMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(templateMap.get(leftChar))) {
                        current--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
            }
        }
        return result;
    }
}
