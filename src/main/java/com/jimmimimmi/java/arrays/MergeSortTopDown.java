package com.jimmimimmi.java.arrays;

import java.util.Arrays;

public class MergeSortTopDown {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        var pivot = nums.length / 2;
        var subArr1 = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        var subArr2 = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(subArr1, subArr2);
    }

    private int[] merge(int[] subArr1, int[] subArr2) {
        var result = new int[subArr1.length + subArr2.length];
        int resultPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while (leftPointer < subArr1.length && rightPointer < subArr2.length) {
            var left = subArr1[leftPointer];
            var right = subArr2[rightPointer];

            if (left <= right) {
                result[resultPointer] = left;
                leftPointer++;
            } else {
                result[resultPointer] = right;
                rightPointer++;
            }
            resultPointer++;
        }

        while (leftPointer < subArr1.length) {
            result[resultPointer] = subArr1[leftPointer];
            leftPointer++;
            resultPointer++;
        }

        while (rightPointer < subArr2.length) {
            result[resultPointer] = subArr2[rightPointer];
            rightPointer++;
            resultPointer++;
        }
        return result;
    }
}
