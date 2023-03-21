package com.jimmimimmi.java.stack;

import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
/*
739. Daily Temperatures
Medium

2462

74

Add to List

Share
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T =
[73, 74, 75, 71, 69, 72, 76, 73], your output should be
[1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[0];
        if (T.length == 1) return new int[]{0};
        var result = new int[T.length];
        var stack = new Stack<Integer>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                var pop = stack.pop();
                result[pop] = (i - pop);
            }
            stack.push(i);
        }
        return result;
    }
}
