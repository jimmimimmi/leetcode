package com.educative.grokking.exercises;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        var left = 0;
        var right = nums1.length;

        while (left <= right) {
            var mid1Idx = (left + right) / 2;
            var mid2Idx = (nums1.length + nums2.length + 1) / 2 - mid1Idx;

            var maxHalf1 = mid1Idx == 0 ? Integer.MIN_VALUE : nums1[mid1Idx - 1];
            var minHalf1 = mid1Idx == nums1.length ? Integer.MAX_VALUE : nums1[mid1Idx];

            var maxHalf2 = mid2Idx == 0 ? Integer.MIN_VALUE : nums2[mid2Idx - 1];
            var minHalf2 = mid2Idx == nums2.length ? Integer.MAX_VALUE : nums2[mid2Idx];

            if (maxHalf1 <= minHalf2 && maxHalf2 <= minHalf1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(maxHalf1, maxHalf2) + Math.min(minHalf1, minHalf2)) / 2.0;
                }
                return Math.max(maxHalf1, maxHalf2);
            } else if (maxHalf1 > minHalf2) {
                right = mid1Idx - 1;
            } else left = mid1Idx + 1;
        }

        return -1;
    }
}
