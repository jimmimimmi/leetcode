package com.jimmimimmi.java.twopointers;

//https://leetcode.com/problems/trapping-rain-water/
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class TrappingRainWater_two_pointers {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        var leftMax = 0;
        var rightMax = 0;

        var leftIdx = 0;
        var rightIdx = height.length - 1;
        var sum = 0;
        while (leftIdx < rightIdx) {
            if (height[leftIdx] < height[rightIdx]) {
                if (height[leftIdx] >= leftMax) leftMax = height[leftIdx];
                else sum += leftMax - height[leftIdx];
                leftIdx++;
            } else {
                if (height[rightIdx] >= rightMax) rightMax = height[rightIdx];
                else sum += rightMax - height[rightIdx];
                rightIdx--;
            }
        }
        return sum;
    }
}
