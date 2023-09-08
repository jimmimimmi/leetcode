package com.educative.grokking.exercises;

// https://leetcode.com/problems/where-will-the-ball-fall/
public class WhereWilltheBallFall {
    public static int[] findExitColumn(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new int[]{};
        }

        var result = new int[grid[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = explore(0, i, grid);
        }
        return result;
    }

    private static int explore(int row, int col, int[][] grid) {
        if (row == grid.length) {
            return col;
        }
        var nextCol = col + grid[row][col];
        if (nextCol >= 0 && nextCol < grid[0].length && grid[row][col] == grid[row][nextCol]) {
            return explore(row + 1, nextCol, grid);
        } else {
            return -1;
        }

    }
}
