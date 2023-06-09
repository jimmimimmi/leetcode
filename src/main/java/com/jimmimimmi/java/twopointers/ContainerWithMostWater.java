package com.jimmimimmi.java.twopointers;

//https://leetcode.com/problems/container-with-most-water/
/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        if (height.length == 2) return Math.min(height[1], height[0]);

        var left = 0;
        var right = height.length - 1;
        var maxArea = 0;
        while (left < right) {
            var currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
