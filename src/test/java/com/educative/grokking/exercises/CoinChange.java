package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CoinChange {
    public static int coinChange(List<Integer> coins, int total) {


        var dp = new int[total + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= total; i++) {
            for (Integer coin : coins) {
                if (i + coin <= total && dp[i] >= 0) {
                    dp[i + coin] = dp[i + coin] <= 0 ? dp[i] + 1 : Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        return dp[total];
    }


}
