package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobberII {
    public static int houseRobber(int[] money) {

        if (money == null || money.length == 0) {
            return 0;
        }
        if (money.length == 1) {
            return money[0];
        }

        if (money.length == 2) {
            return Math.max(money[0], money[1]);
        }


//        var cache1 = new HashMap<String, Integer>();
//        var cache2 = new HashMap<String, Integer>();
        var includingFirst = explore2(0, money, money.length - 1);
        var excludingFirst = explore2(1, money, money.length);
        return Math.max(includingFirst, excludingFirst);
    }

    private static int explore(int currEl, int[] money, int stopIdx, HashMap<String, Integer> cache) {
        if (currEl >= stopIdx) {
            return 0;
        }
        System.out.println();
        var key = currEl + "," + stopIdx;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        var value = Math.max(
                money[currEl] + explore(currEl + 2, money, stopIdx, cache),
                explore(currEl + 1, money, stopIdx, cache)
        );

        cache.put(key, value);
        return value;
    }

    private static int explore2(int currEl, int[] money, int stopIdx) {
        var accumMinus2 = 0;
        var accumMinus1 = 0;
        var best = 0;
        for (int i = currEl; i < stopIdx; i++) {
            var including = accumMinus2 + money[i];
            var excluding = accumMinus1;
            best = Math.max(including, excluding);
            accumMinus2 = accumMinus1;
            accumMinus1 = best;
        }


        return best;

    }
}
