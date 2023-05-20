package com.educative.grokking.exercises;

import java.util.List;

/*
Given a sorted integer array, nums, and an integer value, target, the array is rotated by some arbitrary number.
Search and return the index of target in this array. If the target does not exist, return -1.
 */
public class SearchinRotatedSortedArray {
    public static int binarySearchRotated(List<Integer> nums, int target) {

        var left = 0;
        var right = nums.size() - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (nums.get(mid) == target) return mid;

            if (nums.get(left) <= nums.get(mid)) {
                if (nums.get(left) <= target && target <= nums.get(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums.get(mid) <= target && target <= nums.get(right)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
