package com.jimmimimmi.java.recursion;

//https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return explore(heights, 0, heights.length - 1);
    }

    private int explore(int[] heights, int start, int end) {
        if (start > end) return 0;
        if (start == end) return heights[start];
        var minIdx = getMinIdx(heights, start, end);
        var minHeight = heights[minIdx];
        var currentMinArea = (end - start + 1) * minHeight;
        var leftArea = explore(heights, start, minIdx - 1);
        var rightArea = explore(heights, minIdx + 1, end);

        var leftRightMax = Math.max(leftArea, rightArea);
        return Math.max(currentMinArea, leftRightMax);
    }

    private int getMinIdx(int[] heights, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = start; i <= end; i++) {
            if (heights[i] <= min) {
                min = heights[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

}
