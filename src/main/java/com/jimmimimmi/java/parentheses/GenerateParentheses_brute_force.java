package com.jimmimimmi.java.parentheses;

//https://leetcode.com/articles/generate-parentheses/

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses_brute_force {

    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        var chars = new char[2 * n];
        explore(0, chars, result);
        return result;
    }

    private void explore(int position, char[] chars, List<String> result) {
        if (position == chars.length) {
            if (isValid(chars)) result.add(String.valueOf(chars));
        } else {
            chars[position] = '(';
            explore(position + 1, chars, result);
            chars[position] = ')';
            explore(position + 1, chars, result);
        }
    }

    private boolean isValid(char[] arr) {
        int counter = 0;
        for (char c : arr) {
            if (c == '(') counter++;
            else counter--;

            if (counter < 0) return false;
        }
        return counter == 0;
    }
}
