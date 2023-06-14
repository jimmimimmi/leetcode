package com.educative.grokking.exercises;

public class TribonacciNumber {
    public static int findTribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        var dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 0;

        for (int i = 0; i <= n; i++) {
            if (i + 1 <= n) {
                dp[i + 1] += dp[i];
            }
            if (i + 2 <= n) {
                dp[i + 2] += dp[i];
            }
            if (i + 3 <= n) {
                dp[i + 3] += dp[i];
            }
        }

        return dp[n];
    }
}
