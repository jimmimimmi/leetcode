package com.educative.grokking.exercises;

public class WordSearch {

    // Tip: You may use some of the code templates provided
    // in the support files


    public static boolean wordSearch(char[][] grid, String word) {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                var valid = isValid(grid, word, 0, row, col);
                if (valid) {
                    var isFound = explore(grid, word, 0, row, col);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static final int[][] steps = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static boolean isValid(char[][] grid, String word, int wordIndex, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        return word.charAt(wordIndex) == grid[row][col];
    }


    private static boolean explore(char[][] grid, String word, int wordIndex, int row, int col) {
        if (wordIndex == word.length() - 1) {
            return true;
        }

        for (var step : steps) {
            var nextRow = row + step[0];
            var nextCol = col + step[1];
            var nextIndex = wordIndex + 1;
            var isValidMove = isValid(grid, word, nextIndex, nextRow, nextCol);
            if (isValidMove) {
                var prev = grid[row][col];
                grid[row][col] = '*';
                var result = explore(grid, word, nextIndex, nextRow, nextCol);
                grid[row][col] = prev;
                if (result) return true;
            }
        }

        return false;
    }
}
