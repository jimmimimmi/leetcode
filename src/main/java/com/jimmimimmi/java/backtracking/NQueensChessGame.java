package com.jimmimimmi.java.backtracking;

//https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueensChessGame {

    private boolean canPutQueen(int n, int row, int column, int[] columns, int[] diagonals1, int[] diagonals2) {
        return columns[column] == 0 && diagonals1[row + column] == 0 && diagonals2[row - column + 2 * n] == 0;
    }

    private void explore(int n, int row, int[] columns, int[] diagonals1, int[] diagonals2, int[] result) {
        if (row == n) {
            result[0]++;
            return;
        } else {

            for (int i = 0; i < n; i++) {
                if (canPutQueen(n, row, i, columns, diagonals1, diagonals2)) {
                    columns[i]++;
                    diagonals1[row + i]++;
                    diagonals2[row - i + 2 * n]++;

                    explore(n, row + 1, columns, diagonals1, diagonals2, result);

                    diagonals2[row - i + 2 * n]--;
                    diagonals1[row + i]--;
                    columns[i]--;
                }
            }

        }
    }

    public int totalNQueens(int n) {
        if (n <= 0 || n == 2) return 0;
        if (n == 1) return 1;

        var columns = new int[n];
        var diagonals1 = new int[2 * n];
        var diagonals2 = new int[4 * n];

        var result = new int[1];
        explore(n, 0, columns, diagonals1, diagonals2, result);
        return result[0];
    }
}
