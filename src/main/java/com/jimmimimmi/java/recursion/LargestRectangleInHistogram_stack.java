package com.jimmimimmi.java.recursion;

import java.util.Stack;

public class LargestRectangleInHistogram_stack {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        var stack = new Stack<Integer>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                var pop = stack.pop();
                var area = heights[pop] * i;
                if (!stack.isEmpty()) {
                    area = heights[pop] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            var pop = stack.pop();
            var area = heights[pop] * heights.length;
            if (!stack.isEmpty()) {
                area = heights[pop] * (heights.length - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
