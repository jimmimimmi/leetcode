package com.jimmimimmi.java.graph;

/*
Given an unsorted integer array, nums, return the smallest missing positive integer.
Create an algorithm that runs with an O(n) time complexity and utilizes a constant amount of space.
 */
public class FirstMissingNumber {
    public static int firstMissingPositiveInteger(int[] nums) {
        // 1,2,3,4 => ?
        // 1,2,4,-1 => 3
        // -1,-2,-3 => 1

        for (int i = 0; i < nums.length; i++) {
            var curValue = nums[i];
            var expectedIdx = curValue - 1;
            if (expectedIdx >= nums.length || expectedIdx < 0 || curValue == nums[expectedIdx]) {
                continue;
            }
            nums[i] = nums[expectedIdx];
            nums[expectedIdx] = curValue;
            i--;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
