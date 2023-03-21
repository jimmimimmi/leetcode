package com.jimmimimmi.java.trappingrainwater;

public class TrappingRainWater_two_pointers {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        var leftMax = 0;
        var rightMax = 0;

        var leftIdx = 0;
        var rightIdx = height.length - 1;
        var sum = 0;
        while (leftIdx < rightIdx) {
            if (height[leftIdx] < height[rightIdx]) {
                if (height[leftIdx] >= leftMax) leftMax = height[leftIdx];
                else sum += leftMax - height[leftIdx];
                leftIdx++;
            } else {
                if (height[rightIdx] >= rightMax) rightMax = height[rightIdx];
                else sum += rightMax - height[rightIdx];
                rightIdx--;
            }
        }
        return sum;
    }
}
