package com.jimmimimmi.java.repetition;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        var occupiedRows = new boolean[10][10];
        var occupiedColumns = new boolean[10][10];
        var occupiedBlocks = new boolean[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    var num = board[i][j] - '0';
                    occupiedRows[i][num] = true;
                    occupiedColumns[j][num] = true;
                    occupiedBlocks[3 * (i / 3) + j / 3][num] = true;
                }
            }
        }

        solve(board, 0, 0, occupiedRows, occupiedColumns, occupiedBlocks);
    }

    private boolean canPlace(int num, int row, int column, boolean[][] rows, boolean[][] columns, boolean[][] boxes) {
        return
                !rows[row][num] &&
                        !columns[column][num] &&
                        !boxes[3 * (row / 3) + column / 3][num];
    }

    private boolean solve(char[][] board, int row, int column, boolean[][] rows, boolean[][] columns, boolean[][] boxes) {
        if (row == 9) return true;
        if (column == 9) return solve(board, row + 1, 0, rows, columns, boxes);

        if (board[row][column] != '.') return solve(board, row, column + 1, rows, columns, boxes);

        for (int i = 1; i <= 9; i++) {
            if (canPlace(i, row, column, rows, columns, boxes)) {
                board[row][column] = (char) ('0' + i);
                rows[row][i] = true;
                columns[column][i] = true;
                boxes[3 * (row / 3) + column / 3][i] = true;
                var nextCellSolution = solve(board, row, column + 1, rows, columns, boxes);
                if (nextCellSolution) return true;
                else {
                    board[row][column] = '.';
                    rows[row][i] = false;
                    columns[column][i] = false;
                    boxes[3 * (row / 3) + column / 3][i] = false;
                }
            }
        }
        return false;
    }
}
