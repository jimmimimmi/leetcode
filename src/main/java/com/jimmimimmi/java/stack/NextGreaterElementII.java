package com.jimmimimmi.java.stack;

import java.util.ArrayDeque;

//https://leetcode.com/problems/next-greater-element-ii/
/*
503. Next Greater Element II
Medium

1270

65

Add to List

Share
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        var result = new int[nums.length];
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) return new int[]{-1};
        var decreasingValueIndexesStack = new ArrayDeque<Integer>();
        int maxValue = nums[0];
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            var shiftedIdx = (maxIdx + 1 + i) % nums.length;

            while (!decreasingValueIndexesStack.isEmpty() &&
                    nums[decreasingValueIndexesStack.peekLast()] < nums[shiftedIdx]) {
                var prevSmallerIdx = decreasingValueIndexesStack.removeLast();
                result[prevSmallerIdx] = nums[shiftedIdx];
            }
            decreasingValueIndexesStack.addLast(shiftedIdx);
        }

        while (!decreasingValueIndexesStack.isEmpty()) {
            result[decreasingValueIndexesStack.removeLast()] = -1;
        }

        return result;
    }
}
