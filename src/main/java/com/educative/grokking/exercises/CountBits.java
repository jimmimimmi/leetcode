package com.educative.grokking.exercises;

// https://leetcode.com/problems/counting-bits/description/
public class CountBits {
    public static int[] countingBits(int n) {
        if (n < 0) {
            return new int[]{};
        }
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        var curPower = 0;
        var result = new int[n + 1];
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (Math.pow(2, curPower + 1) == i) {
                result[i] = 1;
                curPower += 1;
            } else {
                var delta = (int) (i - Math.pow(2, curPower));
                result[i] = result[delta] + 1;
            }
        }
        return result;
    }
}
