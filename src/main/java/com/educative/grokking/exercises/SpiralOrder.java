package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/spiral-matrix/
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();

        var top = 0;
        var bottom = matrix.length - 1;
        var left = 0;
        var right = matrix[0].length - 1;
        var directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        var currDirection = 0;
        var row = 0;
        var col = 0;
        var result = new ArrayList<Integer>();

        while (true) {
            result.add(matrix[row][col]);
            var nextRow = row + directions[currDirection][0];
            var nextCol = col + directions[currDirection][1];
            if (nextRow <= bottom && nextRow >= top && nextCol <= right && nextCol >= left) {
                row = nextRow;
                col = nextCol;
            } else {
                if (currDirection == 0) {
                    top++;
                } else if (currDirection == 1) {
                    right--;
                } else if (currDirection == 2) {
                    bottom--;
                } else {
                    left++;
                }
                currDirection = (currDirection + 1) % 4;
                nextRow = row + directions[currDirection][0];
                nextCol = col + directions[currDirection][1];
                if (nextRow <= bottom && nextRow >= top && nextCol <= right && nextCol >= left) {
                    row = nextRow;
                    col = nextCol;
                } else {
                    return result;
                }
            }
        }
    }
}
