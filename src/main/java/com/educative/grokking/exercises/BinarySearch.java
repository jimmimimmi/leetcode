package com.educative.grokking.exercises;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            if (left == right) return nums[left] == target ? left : -1;

            var middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) right = middle - 1;
            if (nums[middle] < target) left = middle + 1;
        }

        return -1;
    }
}
