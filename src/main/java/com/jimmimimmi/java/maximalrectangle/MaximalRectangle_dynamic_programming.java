package com.jimmimimmi.java.maximalrectangle;

import java.util.Arrays;
//https://leetcode.com/articles/maximal-rectangle/
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */

public class MaximalRectangle_dynamic_programming {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int result = 0;

        var lefts = new int[matrix[0].length];
        var rights = new int[matrix[0].length];
        var heights = new int[matrix[0].length];

        Arrays.fill(rights, matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            var left = 0;


            for (int j = 0; j < matrix[0].length; j++) {
                var currentChar = matrix[i][j];
                if (currentChar == '1') heights[j]++;
                else heights[j] = 0;

                if (currentChar == '1') lefts[j] = Math.max(left, lefts[j]);
                else {
                    lefts[j] = 0;
                    left = j + 1;
                }
            }
            var right = matrix[0].length;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                var currentChar = matrix[i][j];
                if (currentChar == '1') rights[j] = Math.min(right, rights[j]);
                else {
                    rights[j] = matrix[0].length;
                    right = j;
                }
            }

            for (int j = 0; j < matrix[0].length; j++) {
                var area = heights[j] * (rights[j] - lefts[j]);
                result = Math.max(result, Math.max(area, 0));
            }
        }

        return result;
    }
}