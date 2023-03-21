package com.jimmimimmi.java.trappingrainwater;

public class TrappingRainWater_dynamic_programming {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        var leftMaxes = new int[height.length];
        var rightMaxes = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
        }

        int result = 0;

        for (int i = 0; i < height.length; i++) {
            var water = Math.min(leftMaxes[i], rightMaxes[i]) - height[i];
            if (water > 0) result += water;
        }
        return result;
    }
}
