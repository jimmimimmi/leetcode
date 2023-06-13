package com.educative.grokking.exercises;


public class SudokuSolver {

    private static boolean isValid(char[][] board, int row, int col, char number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) return false;
            if (board[i][col] == number) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == number) return false;
        }
        return true;
    }

    private static boolean explore(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return explore(board, col == 8 ? row + 1 : row, col == 8 ? 0 : col + 1);
        } else {
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(board, row, col, i)) {
                    var prev = board[row][col];
                    board[row][col] = i;
                    var result = explore(board, col == 8 ? row + 1 : row, col == 8 ? 0 : col + 1);
                    if (result) {
                        return true;
                    }
                    board[row][col] = prev;
                }
            }
            return false;
        }
    }

    public static char[][] solveSudoku(char[][] board) {
        explore(board, 0, 0);
        return board;
    }
}
