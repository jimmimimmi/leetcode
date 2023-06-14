package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.List;

public class KnapsackProfit {


    //5, [2, 3, 5] [5, 5, 20]
    // 2 -> 3, [3, 5] [5, 20] {weight = 3}
    //   -> 5, [2, 3, 5] [5, 5, 20] {weight = 0}

    public static int findMaxKnapsackProfit(int capacity, List<Integer> weights, List<Integer> values) {
        return explore(capacity, weights, values, 0, new HashMap<>());
    }

    public static int findMaxKnapsackProfitTabulated(int capacity, List<Integer> weights, List<Integer> values) {
        var dp = new int[weights.size() + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (weights.get(i - 1) > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    var includingCurrentI = values.get(i - 1) + dp[i - 1][j - weights.get(i - 1)];
                    var excludingCurrentI =   dp[i - 1][j];
                    dp[i][j] = Math.max(includingCurrentI, excludingCurrentI);
                }
            }
        }

        return dp[weights.size()][capacity];
    }

    private static int explore(int capacity, List<Integer> weights, List<Integer> values, int i, HashMap<String, Integer> cache) {
        if (i == values.size() - 1) {
            return weights.get(i) <= capacity ? values.get(i) : 0;
        }
        var key = capacity + "," + i;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        var profitWith = weights.get(i) <= capacity ? values.get(i) : 0;

        var remainCapacityWith = weights.get(i) <= capacity ? capacity - weights.get(i) : capacity;

        var remainingProfitWith = explore(remainCapacityWith, weights, values, i + 1, cache);
        var remainingProfitWithout = explore(capacity, weights, values, i + 1, cache);

        var res = Math.max(profitWith + remainingProfitWith, remainingProfitWithout);
        cache.put(key, res);
        return res;
    }

}
