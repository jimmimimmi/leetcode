package com.educative.grokking.exercises;

import java.util.Arrays;

public class MatchstickstoSquare {
    public static boolean matchstickToSquare(int[] nums) {

        var sum = Arrays.stream(nums).sum();
        var sideD = sum / 4.0;
        var side = (int) sideD;
        if (side != sideD) {
            return false;
        }

        if (Arrays.stream(nums).anyMatch(value -> value > side)) {
            return false;
        }

        var taken = new boolean[nums.length];


        return explore(nums, taken, side, sum, side, 0);
    }

    private static boolean explore(int[] nums,
                                   boolean[] taken,
                                   int sideLength,
                                   int remainingPerimeter,
                                   int remainingLength,
                                   int idx) {
        var currentLength = nums[idx];
        if (currentLength == remainingLength && remainingPerimeter == remainingLength) {
            return true;
        }


        var newRemainingLength = currentLength == remainingLength ? sideLength : remainingLength - currentLength;

        var sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append(taken[i] ? "(t), " : ", ");
        }
        sb.append("]");


        System.out.println("Explore. idx: " + idx + ", arr: " + sb + ", remainingLength: " + remainingLength);
        taken[idx] = true;
        for (int nextIdx = 0; nextIdx < nums.length; nextIdx++) {
            if (nextIdx == idx) continue;
            if (isValid(nums, taken, newRemainingLength, nextIdx)) {
                var res = explore(nums, taken, sideLength, remainingPerimeter - currentLength, newRemainingLength, nextIdx);
                if (res) return true;
            }
        }
        taken[idx] = false;
        return false;
    }

    private static boolean isValid(int[] nums,
                                   boolean[] taken,
                                   int remainingLength,
                                   int idx) {
        if (taken[idx]) return false;
        return nums[idx] <= remainingLength;
    }


}
