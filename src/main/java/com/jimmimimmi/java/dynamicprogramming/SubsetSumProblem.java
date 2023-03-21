package com.jimmimimmi.java.dynamicprogramming;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java

public class SubsetSumProblem {
    public boolean canGetSubsetEqualTo(int n, int[] values) {
        var dp = new boolean[values.length + 1][n + 1];

        dp[0][0] = true;
        for (int row = 1; row <= values.length; row++) {
            for (int currentValue = 0; currentValue <= n; currentValue++) {
                if (currentValue == 0) {
                    dp[row][currentValue] = true;
                    continue;
                }
                if (values[row - 1] > currentValue) {
                    dp[row][currentValue] = dp[row - 1][currentValue];
                } else if (values[row - 1] == currentValue) {
                    dp[row][currentValue] = true;
                } else {
                    dp[row][currentValue] =
                            dp[row - 1][currentValue - values[row - 1]]
                                    || dp[row - 1][currentValue]
                    ;
                }
            }
        }

        return dp[values.length][n];
    }
}
