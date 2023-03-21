package com.jimmimimmi.java.dynamicprogramming;

import junit.framework.TestCase;

public class PartitionEqualSubsetSumTest extends TestCase {

    public void testCanPartition() {
        assertTrue(new PartitionEqualSubsetSum().canPartition_dp(new int[]{1, 5, 11, 5}));
        assertFalse(new PartitionEqualSubsetSum().canPartition_dp(new int[]{1, 2, 3, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dp(new int[]{3, 13, 1, 7, 6, 5, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dp(new int[]{23, 13, 11, 7, 6, 5, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dp(new int[]{5, 5, 6, 7, 11, 13, 23}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dp(new int[]{40, 99, 2, 19, 62, 76, 70, 2, 58, 9, 72, 93, 99, 78, 22, 82, 30, 33, 14, 100, 4, 58, 43, 59, 11, 84, 43, 57, 54, 25, 54, 67, 55, 87, 61, 51, 40, 10, 17, 37, 77, 22, 6, 70, 31, 9, 91, 15, 31, 23, 54, 73, 73, 91, 32, 65, 42, 35, 68, 35, 46, 4, 15, 55, 81, 13, 14, 99, 17, 30, 31, 57, 34, 30, 1, 75, 2, 45, 77, 36, 76, 39, 44, 26, 94, 3, 9, 25, 56, 99, 13, 61, 22, 5, 60, 9, 43, 94, 1, 31}));

        assertTrue(new PartitionEqualSubsetSum().canPartition_dpOptimised(new int[]{1, 5, 11, 5}));
        assertFalse(new PartitionEqualSubsetSum().canPartition_dpOptimised(new int[]{1, 2, 3, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dpOptimised(new int[]{3, 13, 1, 7, 6, 5, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dpOptimised(new int[]{23, 13, 11, 7, 6, 5, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dpOptimised(new int[]{5, 5, 6, 7, 11, 13, 23}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_dpOptimised(new int[]{40, 99, 2, 19, 62, 76, 70, 2, 58, 9, 72, 93, 99, 78, 22, 82, 30, 33, 14, 100, 4, 58, 43, 59, 11, 84, 43, 57, 54, 25, 54, 67, 55, 87, 61, 51, 40, 10, 17, 37, 77, 22, 6, 70, 31, 9, 91, 15, 31, 23, 54, 73, 73, 91, 32, 65, 42, 35, 68, 35, 46, 4, 15, 55, 81, 13, 14, 99, 17, 30, 31, 57, 34, 30, 1, 75, 2, 45, 77, 36, 76, 39, 44, 26, 94, 3, 9, 25, 56, 99, 13, 61, 22, 5, 60, 9, 43, 94, 1, 31}));

        assertTrue(new PartitionEqualSubsetSum().canPartition_recursive(new int[]{1, 5, 11, 5}));
        assertFalse(new PartitionEqualSubsetSum().canPartition_recursive(new int[]{1, 2, 3, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_recursive(new int[]{3, 13, 1, 7, 6, 5, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_recursive(new int[]{23, 13, 11, 7, 6, 5, 5}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_recursive(new int[]{5, 5, 6, 7, 11, 13, 23}));
        assertTrue(new PartitionEqualSubsetSum().canPartition_recursive(new int[]{40, 99, 2, 19, 62, 76, 70, 2, 58, 9, 72, 93, 99, 78, 22, 82, 30, 33, 14, 100, 4, 58, 43, 59, 11, 84, 43, 57, 54, 25, 54, 67, 55, 87, 61, 51, 40, 10, 17, 37, 77, 22, 6, 70, 31, 9, 91, 15, 31, 23, 54, 73, 73, 91, 32, 65, 42, 35, 68, 35, 46, 4, 15, 55, 81, 13, 14, 99, 17, 30, 31, 57, 34, 30, 1, 75, 2, 45, 77, 36, 76, 39, 44, 26, 94, 3, 9, 25, 56, 99, 13, 61, 22, 5, 60, 9, 43, 94, 1, 31}));
    }
}