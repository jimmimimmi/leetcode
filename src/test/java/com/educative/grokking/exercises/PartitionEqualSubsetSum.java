package com.educative.grokking.exercises;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canPartitionArray(int[] arr) {
        var sum = Arrays.stream(arr).sum();
        if (sum / 2 != sum / 2.0) return false;
        var target = sum / 2;

        // rows are targets, columns are subarrays starting from beginnin: [], [n1], [n1,n2], [n1, n2, n3], ... [n1..nn].
        var dp = new boolean[target + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (arr[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - arr[j - 1]][j - 1];
                }
            }
        }


        return dp[target][arr.length];
    }
}
