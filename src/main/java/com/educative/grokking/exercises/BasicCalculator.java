package com.educative.grokking.exercises;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator/description/
public class BasicCalculator {
    public static int calculator(String expression) {

        var stack = new Stack<Integer>();
        var currentValue = 0;
        var result = 0;
        var sign = 1;
        var chars = expression.toCharArray();
        for (var c : chars) {
            if (c >= '0' && c <= '9') {
                currentValue = currentValue * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * currentValue;
                sign = c == '+' ? 1 : -1;
                currentValue = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
                currentValue = 0;
            } else if (c == ')') {
                result += sign * currentValue;
                result = result * stack.pop();
                result = result + stack.pop();
                currentValue = 0;
            }
        }


        return result + sign * currentValue;
    }
}
