package com.educative.grokking.exercises;

// https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        //1,5,6,7,3,6,8
        //1,5,6,7,0,5,6
        //-7,0,-5
        //1,5,6,7,-1,5,6
        //1,5,6,7,-1,5,-6
        //1,-5,6,7,-1,5,-6


        var minSoFar = nums[0];
        var maxSoFar = nums[0];
        var best = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            var newMin = Math.min(num, Math.min(minSoFar * num, maxSoFar * num));
            var newMax = Math.max(num, Math.max(minSoFar * num, maxSoFar * num));

            minSoFar = Math.min(minSoFar, newMin);
            maxSoFar = Math.max(maxSoFar, newMax);

            best = Math.max(maxSoFar, best);
        }
        return best;
    }
}
