package com.jimmimimmi.java.trees;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
    public static int longestCommonSubsequenceDp(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        var dp = new int[str1.length() + 1][str2.length() + 1];


        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        return explore(str1, str2, new HashMap<>(), 0, 0);
    }

    private static int explore(String str1, String str2, HashMap<String, Integer> cache, int i, int j) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }
        var key = i + "," + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            var res = 1 + explore(str1, str2, cache, i + 1, j + 1);
            cache.put(key, res);
            return res;
        } else {
            var next1 = explore(str1, str2, cache, i, j + 1);
            var next2 = explore(str1, str2, cache, i + 1, j);

            var res = Math.max(next1, next2);
            cache.put(key, res);
            return res;
        }
    }
}
