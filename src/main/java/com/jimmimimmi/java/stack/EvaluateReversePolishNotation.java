package com.jimmimimmi.java.stack;

import java.util.ArrayDeque;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
/*
150. Evaluate Reverse Polish Notation
Medium

900

441

Add to List

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") &&
                    !tokens[i].equals("-") &&
                    !tokens[i].equals("*") &&
                    !tokens[i].equals("/")) {
                stack.add(Integer.parseInt(tokens[i]));
            } else {
                var second = stack.removeLast();
                var first = stack.removeLast();

                if (tokens[i].equals("+")) {
                    stack.addLast(first + second);
                } else if (tokens[i].equals("-")) {
                    stack.addLast(first - second);
                } else if (tokens[i].equals("*")) {
                    stack.addLast(first * second);
                } else if (tokens[i].equals("/")) {
                    stack.addLast(first / second);
                }
            }
        }
        return stack.removeLast();
    }
}
