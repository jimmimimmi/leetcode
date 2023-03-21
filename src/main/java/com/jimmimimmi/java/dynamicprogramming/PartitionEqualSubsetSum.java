package com.jimmimimmi.java.dynamicprogramming;

import java.util.HashMap;

//https://leetcode.com/problems/partition-equal-subset-sum/
/*
416. Partition Equal Subset Sum
Medium

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition_dp(int[] nums) {
        int sum = 0;
        for (var num : nums) sum += num;
        if (sum % 2 != 0) return false;

        var lookingFor = sum / 2;

        var dp = new boolean[nums.length + 1][lookingFor + 1];
        dp[0][0] = true;
        counter = 0;

        for (int valueIdx = 1; valueIdx <= nums.length; valueIdx++) {
            for (int possibleSum = 0; possibleSum <= lookingFor; possibleSum++) {
                if (possibleSum == 0) {
                    dp[valueIdx][possibleSum] = true;
                    continue;
                }
                if (nums[valueIdx - 1] == possibleSum) {
                    dp[valueIdx][possibleSum] = true;
                } else if (nums[valueIdx - 1] > possibleSum) {
                    dp[valueIdx][possibleSum] = dp[valueIdx - 1][possibleSum];
                } else {
                    dp[valueIdx][possibleSum] =
                            dp[valueIdx - 1][possibleSum - nums[valueIdx - 1]]
                                    || dp[valueIdx - 1][possibleSum];
                }

                counter++;
            }
        }
        System.out.println("canPartition_dp . nums.length " + nums.length + ", lookingFor " + lookingFor + ",  counter " + counter);
        return dp[nums.length][lookingFor];
    }

    public boolean canPartition_dpOptimised(int[] nums) {
        int sum = 0;
        for (var num : nums) sum += num;
        if (sum % 2 != 0) return false;

        var lookingFor = sum / 2;

        var dp = new boolean[lookingFor + 1];
        dp[0] = true;
        for (var num : nums) {
            for (int j = lookingFor; j >= num; j--) {
                counter++;
                dp[j] = dp[j] || dp[j - num];
                if (dp[lookingFor]) {
                    System.out.println("canPartition_dpOptimised . nums.length " + nums.length + ", lookingFor " + lookingFor + ",  counter " + counter);
                    return true;
                }
            }
        }
        System.out.println("canPartition_dpOptimised . nums.length " + nums.length + ", lookingFor " + lookingFor + ",  counter " + counter);

        return dp[lookingFor];
    }

    private void printMatrix(boolean[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                var v = "F\t";
                if (matrix[row][col]) v = "T\t";
                System.out.print(v);
            }
            System.out.println();
        }
    }


    private int counter = 0;

    public boolean canPartition_recursive(int[] nums) {
        int sum = 0;
        for (var num : nums) sum += num;
        if (sum % 2 != 0) return false;

        var lookingFor = sum / 2;
        var cache = new HashMap<PointerToSum, Boolean>();

        counter = 0;
        System.out.println("nums.length " + nums.length + ", lookingFor " + lookingFor);
        var result = hasSolution(cache, nums, lookingFor, 0);
        System.out.println("cache size " + cache.size() + ", counter " + counter);
        return result;
    }

    class PointerToSum {
        private final int pointer;
        private final int sum;

        public PointerToSum(int pointer, int sum) {
            this.pointer = pointer;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PointerToSum that = (PointerToSum) o;

            if (pointer != that.pointer) return false;
            return sum == that.sum;
        }

        @Override
        public int hashCode() {
            int result = pointer;
            result = 31 * result + sum;
            return result;
        }
    }

    private boolean hasSolution(HashMap<PointerToSum, Boolean> cache, int[] nums, int expectedSum, int currentPointer) {
        var pointerToSum = new PointerToSum(currentPointer, expectedSum);
        var value = cache.get(pointerToSum);
        if (value != null) {
            return value;
        }

        counter++;
//        System.out.println("counter " + counter + ", pointer " + currentPointer + ", sum" + currentPointer);

        if (currentPointer == nums.length) {
            cache.put(pointerToSum, false);
            return false;
        }
        if (expectedSum == 0) {
            cache.put(pointerToSum, true);
            return true;
        }

        var result = hasSolution(cache, nums, expectedSum, currentPointer + 1);
        if (result) {
            cache.put(pointerToSum, true);
            return true;
        }

        if (nums[currentPointer] <= expectedSum) {
            result = hasSolution(
                    cache, nums, expectedSum - nums[currentPointer], currentPointer + 1);
        }

        cache.put(pointerToSum, result);
        return result;
    }
}
