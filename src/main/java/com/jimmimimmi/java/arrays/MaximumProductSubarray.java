package com.jimmimimmi.java.arrays;

//https://leetcode.com/problems/maximum-product-subarray/
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        var max = nums[0];
        var product = 1;

        //the main idea to find max subproduct between sezo values.
        // In order to eliminate odd negative numbers we traverse twice from left to right and then backwards

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0) product = 1;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0) product = 1;
        }

        return max;
    }
}
