package com.jimmimimmi.java.trappingrainwater;

//https://leetcode.com/problems/trapping-rain-water/
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

public class TrappingRainWater_brute_force {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        var result = 0;
        for (int current = 1; current < height.length - 1; current++) {
            var leftMax = 0;
            var rightMax = 0;
            for (int i = current - 1; i >= 0; i--) {
                leftMax = Math.max(height[i], leftMax);
            }

            for (int i = current + 1; i < height.length; i++) {
                rightMax = Math.max(height[i], rightMax);
            }

            var res = Math.min(leftMax, rightMax) - height[current];
            if (res > 0) result += res;
        }

        return result;
    }
}
