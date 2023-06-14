package com.educative.grokking.exercises;

/*
You are climbing a staircase. It takes
�
n
 steps to reach the top. Each time, you can either climb
1
1
 or
2
2
 steps. In how many distinct ways can you climb to the top?


 */

public class ClimbingStairs {
    public static int climbStairs(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        var dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 1; i <= n; i++) {
            if (i + 1 <= n) {
                dp[i + 1] += dp[i];
            }
            if (i + 2 <= n) {
                dp[i + 2] += dp[i];
            }
        }

        return dp[n];
    }
}
