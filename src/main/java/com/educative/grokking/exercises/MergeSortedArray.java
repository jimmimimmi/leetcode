package com.educative.grokking.exercises;

/*
Given two sorted integer arrays,
nums1 and nums2
, and the number of data elements in each array, m and n
, implement a function that merges the second array into the first one. You have to modify
nums1  in place.

Note: Assume that nums1 has a size equal to m+n
, meaning it has enough space to hold additional elements from
nums2
.
 */
public class MergeSortedArray {

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

        var currentIdx = nums1.length - 1;
        var idx1 = m - 1;
        var idx2 = n - 1;
        while (currentIdx >= 0) {
            if (idx1 >= 0 && idx2 >= 0) {
                if (nums1[idx1] >= nums2[idx2]) {
                    nums1[currentIdx] = nums1[idx1];
                    idx1--;
                } else {
                    nums1[currentIdx] = nums2[idx2];
                    idx2--;
                }
            } else if (idx1 >= 0) {
                nums1[currentIdx] = nums1[idx1];
                idx1--;
            } else if (idx2 >= 0) {
                nums1[currentIdx] = nums2[idx2];
                idx2--;
            }
            currentIdx--;
        }

        return nums1;
    }
}
