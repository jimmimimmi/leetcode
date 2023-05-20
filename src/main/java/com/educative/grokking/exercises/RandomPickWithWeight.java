package com.educative.grokking.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomPickWithWeight {

    private final int[] runningSums;
    private final int[] weights;
    private final Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        int sum = 0;
        this.runningSums = new int[w.length];
        this.weights = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum = sum + w[i];
            runningSums[i] = sum;
            weights[i] = w[i];
        }
    }

    public int pickIndex() {
        var target = random.nextInt(runningSums[runningSums.length - 1] + 1);
        var left = 0;
        var right = runningSums.length - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (mid == 0 && runningSums[mid] > target) return mid;
            if (runningSums[mid] == target) return mid;
            if (runningSums[mid - 1] <= target && target < runningSums[mid]) return mid;
            if (target < runningSums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int sumW(int[] arr) {
        int sum = 0;
        //Loop through the array to calculate sum of elements
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    static float round(float var) {
        float value = (int) (var * 100 + .5);
        return (float) value / 100;
    }
}
