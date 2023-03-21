package com.jimmimimmi.java.trappingrainwater;

import java.util.Stack;

public class TrappingRainWater_stack {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        var stack = new Stack<Integer>();
        var sum = 0;

        for (int current = 0; current < height.length; current++) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                var pop = stack.pop();
                if (!stack.isEmpty())
                    sum += (current - stack.peek() - 1) * (Math.min(height[current], height[stack.peek()]) - height[pop]);
            }
            stack.push(current);
        }
        return sum;
    }
}
