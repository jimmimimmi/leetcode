package com.jimmimimmi.java.backtracking;


//https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */
public class Sudoku {

    private int getBox(int row, int column) {
        return 3 * (row / 3) + column / 3;
    }

    private boolean canPlace(int number, int row, int column, char[][] board, int[][] rows, int[][] columns, int[][] boxes) {
        return
                board[row][column] == '.' &&
                        rows[number][row] == 0 &&
                        columns[number][column] == 0 &&
                        boxes[number][getBox(row, column)] == 0;
    }

    private boolean explore(char[][] board, int row, int column, int[][] rows, int[][] columns, int[][] boxes) {
        if (row == 9) return true;

        if (board[row][column] != '.') {
            if (column == 8) {
                return explore(board, row + 1, 0, rows, columns, boxes);
            } else {
                return explore(board, row, column + 1, rows, columns, boxes);
            }
        } else {
            for (int num = 1; num <= 9; num++) {
                var canPlace = canPlace(num, row, column, board, rows, columns, boxes);
                if (canPlace) {
                    board[row][column] = (char) (((int) '0') + num);
                    rows[num][row]++;
                    columns[num][column]++;
                    boxes[num][getBox(row, column)]++;

                    var nextLevelResult = false;
                    if (column == 8) {
                        nextLevelResult = explore(board, row + 1, 0, rows, columns, boxes);
                    } else {
                        nextLevelResult = explore(board, row, column + 1, rows, columns, boxes);
                    }

                    if (nextLevelResult) {
                        return true;
                    } else {
                        board[row][column] = '.';
                        rows[num][row]--;
                        columns[num][column]--;
                        boxes[num][getBox(row, column)]--;
                    }
                }
            }
            return false;
        }
    }

    public void solveSudoku(char[][] board) {
        var rows = new int[10][10];
        var columns = new int[10][10];
        var boxes = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                var c = board[i][j];
                if (c != '.') {
                    var num = (c - '1') + 1;
                    rows[num][i]++;
                    columns[num][j]++;
                    boxes[num][getBox(i, j)]++;
                }
            }
        }

        explore(board, 0, 0, rows, columns, boxes);
    }
}
