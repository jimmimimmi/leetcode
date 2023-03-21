package com.jimmimimmi.java.dynamicprogramming;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.stream.Collectors;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java

public class KnapsackProblem01 {
    public int bottomUpDP(int val[], int wt[], int W) {
        int K[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    K[i][j] = 0;
                    continue;
                }
                if (j - wt[i - 1] >= 0) {
                    K[i][j] = Math.max(K[i - 1][j], K[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    K[i][j] = K[i - 1][j];
                }
            }
        }
        return K[val.length][W];
    }

    class Tuple {
        private final int v1;
        private final int v2;

        Tuple(int v1, int v2) {

            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple tuple = (Tuple) o;

            if (v1 != tuple.v1) return false;
            return v2 == tuple.v2;
        }

        @Override
        public int hashCode() {
            int result = v1;
            result = 31 * result + v2;
            return result;
        }
    }

    public int getMaximumWeight_bottomUpDp(int[] val, int[] weights, int maximumWeight) {
        var dp = new int[weights.length + 1][maximumWeight + 1];

        for (int itemIdx = 0; itemIdx <= weights.length; itemIdx++) {
            for (int possibleWeight = 0; possibleWeight <= maximumWeight; possibleWeight++) {
                if (itemIdx == 0 || possibleWeight == 0) {
                    dp[itemIdx][possibleWeight] = 0;
                    continue;
                }
                var skipItemTotalValue = dp[itemIdx - 1][possibleWeight];
                if (possibleWeight >= weights[itemIdx - 1]) {
                    var pickItemTotalValue = val[itemIdx - 1] + dp[itemIdx - 1][possibleWeight - weights[itemIdx - 1]];
                    dp[itemIdx][possibleWeight] = Math.max(skipItemTotalValue, pickItemTotalValue);
                } else {
                    dp[itemIdx][possibleWeight] = skipItemTotalValue;
                }
            }
        }

        var result = new ArrayDeque<Integer>();
        int currentRow = weights.length;
        int currentColumn = maximumWeight;
        while (currentColumn > 0 && currentRow > 0) {
            if (dp[currentRow][currentColumn] == dp[currentRow - 1][currentColumn]) {
                currentRow--;
                continue;
            }
            result.addLast(currentRow - 1);
            currentColumn -= weights[currentRow - 1];
            currentRow--;
        }

        var sumVal = result.stream().map(i -> val[i]).reduce(Integer::sum);
        var sumWeight = result.stream().map(i -> weights[i]).reduce(Integer::sum);

        System.out.println("sumVal " + sumVal + ", sumWeight " + sumWeight + ", maximumVal " + dp[weights.length][maximumWeight]);
        System.out.println(result.stream().map(Object::toString).collect(Collectors.joining("->")));

        return dp[weights.length][maximumWeight];
    }

    public int getMaximumWeight_recursive(int[] val, int[] weights, int maximumWeight) {
        var cache = new HashMap<Tuple, Integer>();
        return explore(cache, val, weights, maximumWeight, 0);
    }

    private int explore(HashMap<Tuple, Integer> cache, int[] val, int[] weights, int weight, int currentPointer) {
        if (currentPointer == weights.length) return 0;
        if (weight <= 0) return 0;

        var resultWithoutCurrent = explore(cache, val, weights, weight, currentPointer + 1);
        var key = new Tuple(currentPointer, weight);
        if (cache.containsKey(key)) return cache.get(key);
        if (weights[currentPointer] <= weight) {
            var resultWithCurrent = val[currentPointer] +
                    explore(cache, val, weights, weight - weights[currentPointer], currentPointer + 1);

            if (resultWithoutCurrent > resultWithCurrent) {
                cache.put(key, resultWithoutCurrent);
                return resultWithoutCurrent;
            } else {
                cache.put(key, resultWithCurrent);
                return resultWithCurrent;
            }
        } else {
            cache.put(key, resultWithoutCurrent);
            return resultWithoutCurrent;
        }

    }
}
