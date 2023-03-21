package com.jimmimimmi.java.maximalrectangle;

import java.util.Stack;

public class MaximalRectangle_stack {
    private int getMaxArea(int[] heights) {
        var stack = new Stack<Integer>();
        var result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                var pop = stack.pop();
                var area = i * heights[pop];
                if (!stack.isEmpty()) {
                    area = (i - stack.peek() - 1) * heights[pop];
                }
                result = Math.max(result, area);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            var pop = stack.pop();
            var area = heights.length * heights[pop];
            if (!stack.isEmpty()) {
                area = (heights.length - stack.peek() - 1) * heights[pop];
            }
            result = Math.max(result, area);
        }
        return result;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        var heights = new int[matrix[0].length];
        var result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            var area = getMaxArea(heights);
            result = Math.max(result, area);
        }
        return result;
    }
}
