package com.jimmimimmi.java.graph;

/*
We are given an unsorted array, nums, with n elements and each element is in the range [1,n] inclusive.
The array originally contained all the elements from 1 to n but due to a data error,
one of the numbers is duplicated, which causes another number missing.
Find and return the corrupt pair (missing, duplicated).
 */
public class FindCorruptPair {
    /*
      1, 4, 1, 5, 2 => 3, 1

      1, 2, 1, 4, 5

    */
    public static int[] findCorruptPair(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            var currVal = nums[i];
            var correctIdx = currVal - 1;
            if (correctIdx >= nums.length || correctIdx < 0 || currVal == nums[correctIdx]) {
                continue;
            }
            nums[i] = nums[correctIdx];
            nums[correctIdx] = currVal;
            i--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{i + 1, nums[i]};
            }
        }


        return new int[]{0, 0};
    }
}
