package com.jimmimimmi.java.parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_backtracking {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        var chars = new char[2 * n];
        explore(0, 0, 0, chars, result);
        return result;
    }

    private void explore(int pos, int open, int close, char[] chars, List<String> result) {
        if (pos == chars.length) result.add(String.valueOf(chars));
        else {
            if (open < chars.length / 2) {
                chars[pos] = '(';
                explore(pos + 1, open + 1, close, chars, result);
            }
            if (close < open) {
                chars[pos] = ')';
                explore(pos + 1, open, close + 1, chars, result);
            }
        }
    }
}
