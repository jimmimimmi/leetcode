package com.jimmimimmi.java.trees;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    /*
            pamnma
            aaaaa
       p  a  m  n  m  a
    p  1  0  0
    a     1  0  0     1
    m        1  0  1
    n           1  0  0
    m              1  0
    a                 1


     */

    // lever
    public static int countPalindromicSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        var dp = new boolean[s.length()][s.length()];
        var result = 0 ;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            result++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result++;
            }
        }

        for (int length = 3; length <= s.length(); length++) {
            for (int start = 0; start < s.length(); start++) {
                var end = start + length - 1;
                if (end < s.length()){
                    if (s.charAt(start) == s.charAt(end) && dp[start+1][end-1]){
                        dp[start][end] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
