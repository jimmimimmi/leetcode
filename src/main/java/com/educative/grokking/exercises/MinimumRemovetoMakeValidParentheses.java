package com.educative.grokking.exercises;

import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
public class MinimumRemovetoMakeValidParentheses {
    public static String minRemoveParentheses(String s) {

        var bracesIdx = new Stack<Integer>();
        var bracesVal = new Stack<Character>();
        var chars = s.toCharArray();
        for (var i = 0; i < s.length(); i++) {
            var curChar = chars[i];
            if (curChar == '(') {
                bracesIdx.push(i);
                bracesVal.push(curChar);
            } else if (curChar == ')') {
                if (!bracesVal.empty() && bracesVal.peek() == '(') {
                    bracesVal.pop();
                    bracesIdx.pop();
                } else {
                    bracesIdx.push(i);
                    bracesVal.push(curChar);
                }
            }
        }

        var sb = new StringBuilder();
        for (var i = chars.length - 1; i >= 0; i--) {
            if (!bracesIdx.empty() && i == bracesIdx.peek()) {
                bracesIdx.pop();
                bracesVal.pop();
            } else {
                sb.insert(0, chars[i]);
            }
        }

        return sb.toString();
    }
}
