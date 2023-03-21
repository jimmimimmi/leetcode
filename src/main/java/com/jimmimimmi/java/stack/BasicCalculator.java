package com.jimmimimmi.java.stack;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/basic-calculator/
/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "( 1+ ( 4 + 5 - 2) - 3) + ( 6 + 8 ) + 2"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */
public class BasicCalculator {

    public int calculate(String s) {
        return calculate(s, new AtomicInteger(0));
    }

    private int calculate(String s, AtomicInteger ind) {
        var sign = 1;
        int result = 0;

        while (ind.get() < s.length()) {
            if (s.charAt(ind.get()) == ' ') {
                ind.incrementAndGet();
                continue;
            }

            if (Character.isDigit(s.charAt(ind.get()))) {
                var num = extractNum(s, ind); //ind shows to the first non digit after digit
                result += num * sign;
                sign = 1;
                continue;
            }

            if (s.charAt(ind.get()) == '+') {
                sign = 1;
                ind.incrementAndGet();
                continue;
            }

            if (s.charAt(ind.get()) == '-') {
                sign = -1;
                ind.incrementAndGet();
                continue;
            }

            if (s.charAt(ind.get()) == '(') {
                ind.incrementAndGet();
                var subResult = calculate(s, ind);
                result += subResult * sign;
                sign = 1;
                ind.incrementAndGet();
                continue;
            }

            if (s.charAt(ind.get()) == ')') {
                return result;
            }
        }
        return result;
    }

    private int extractNum(String s, AtomicInteger ind) {
        int res = 0;
        while (ind.get() < s.length()) {
            var c = s.charAt(ind.get());
            if (Character.isDigit(c)) {
                res = res * 10 + (c - '0');
                ind.incrementAndGet();
            } else break;
        }
        return res;
    }
}

