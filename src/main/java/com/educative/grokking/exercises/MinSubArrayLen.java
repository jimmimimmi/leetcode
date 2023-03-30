package com.educative.grokking.exercises;

/*
Given an array of positive integers nums and a positive integer target,
find the window size of the shortest contiguous subarray whose sum is greater than or equal to the target value.
If no subarray is found, 0 is returned.
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] arr) {
        int currentSum = 0;
        Integer result = null;
        var left = 0;
        var right = 0;

        while (right < arr.length) {
            currentSum += arr[right];
            while (currentSum >= target && left <= right) {
                var length = right - left + 1;
                if (result == null || length < result) {
                    result = length;
                }
                currentSum -= arr[left];
                left++;
            }
            right++;
        }

        return result == null ? 0 : result;
    }
}
