package com.jimmimimmi.java.stack;

//https://leetcode.com/articles/sum-of-subarray-minimums/
/*
907. Sum of Subarray Minimums

Average Rating: 3.23 (84 votes)

Sept. 16, 2018  |  38.9K views
Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.

Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.

Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000
 */

import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] array) {
        int modulo = 1_000_000_007;

        // prev has i* - 1 in increasing order of array[i* - 1]
        // where i* is the answer to query j
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            while (!stack.isEmpty() && array[i] <= array[stack.peek()])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // next has k* + 1 in increasing order of array[k* + 1]
        // where k* is the answer to query j
        stack = new Stack<>();
        int[] next = new int[array.length];
        for (int k = array.length - 1; k >= 0; --k) {
            while (!stack.isEmpty() && array[k] < array[stack.peek()])
                stack.pop();
            next[k] = stack.isEmpty() ? array.length : stack.peek();
            stack.push(k);
        }

        // Use prev/next array to count answer
        long ans = 0;
        for (int i = 0; i < array.length; ++i) {
            ans += (i - prev[i]) * (next[i] - i) % modulo * array[i] % modulo;
            ans %= modulo;
        }
        return (int) ans;

    }
}

class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] array) {
        int modulo = 1_000_000_007;

        Stack<RepInteger> stack = new Stack<>();
        int ans = 0, dot = 0;
        for (int j = 0; j < array.length; ++j) {
            // Add all answers for subarrays [i, j], i <= j
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= array[j]) {
                RepInteger node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }
            stack.push(new RepInteger(array[j], count));
            dot += array[j] * count;
            ans += dot;
            ans %= modulo;
        }

        return ans;
    }
}

class RepInteger {
    int val, count;
    RepInteger(int v, int c) {
        val = v;
        count = c;
    }
}