package com.educative.grokking.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SudokuSolver2 {
    private static final int GRID_SIZE = 9;

    private static boolean isValidPlacement(char[][] board, char number, int row, int col) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[row][i] == number) return false;
            if(board[i][col] == number) return false;
            if(board[3 * (row / 3) + i/3][3 * (col / 3) + i%3] == number) return false;
        }
        return true;
    }

    private static boolean explore(char[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {

                if (board[row][column] == '.') {

                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidPlacement(board, num, row, column)) {

                            board[row][column] = num;
                            if (explore(board)) return true;
                            board[row][column] = '.';

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] solveSudoku(char[][] board) throws JsonProcessingException {
        explore(board);
        return board;
    }
}
