package com.jimmimimmi.java.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
/*
131. Palindrome Partitioning
Medium

Add to List

Share
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aabb"
Output:
[
  ["aa","b","b"],
  ["a","a","b", "b"],
  ["a","a","bb"],

    0   1   2   3
0   t   t
1       t   f
2           t   t
3               t

]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        if (s.length() == 1) {
            result.add(new ArrayList<>() {{
                add(s);
            }});
            return result;
        }
        explore(s, 0, new ArrayList<>(), result);
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private void explore(String s, int currentIdx, ArrayList<String> subResult, ArrayList<List<String>> output) {
        if (currentIdx == s.length()) {
            output.add(new ArrayList<>(subResult));
            return;
        }
        for (int end = currentIdx; end < s.length(); end++) {
            if (isPalindrome(s, currentIdx, end)) {
                subResult.add(s.substring(currentIdx, end + 1));
                explore(s, end + 1, subResult, output);
                subResult.remove(subResult.size() - 1);
            }
        }

    }


}
