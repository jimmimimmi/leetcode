package com.educative.grokking.exercises;

public class SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] nums) {

        var left = 0;
        var right = nums.length - 1;
        while (left < right) {
            var mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            // 112234455667788
            // 1122344
            // 1122-344
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
