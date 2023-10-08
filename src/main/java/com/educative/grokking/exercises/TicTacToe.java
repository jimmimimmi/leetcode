package com.educative.grokking.exercises;

// https://leetcode.com/problems/design-tic-tac-toe/
public class TicTacToe {
    private int[][] rowsOccupied;
    private int[][] colsOccupied;
    private int[][] diagOccupied;

    private int length;

    public TicTacToe(int n) {
        rowsOccupied = new int[2][n];
        colsOccupied = new int[2][n];
        diagOccupied = new int[2][2];
        length = n;
    }

    public int move(int row, int col, int player) {

        rowsOccupied[player - 1][row]++;
        if (rowsOccupied[player - 1][row] == length) {
            return player;
        }
        colsOccupied[player - 1][col]++;
        if (colsOccupied[player - 1][col] == length) {
            return player;
        }

        if (col == row) {
            diagOccupied[player - 1][0]++;
            if (diagOccupied[player - 1][0] == length) {
                return player;
            }
        }

        if (col == length - 1 - row) {
            diagOccupied[player - 1][1]++;
            if (diagOccupied[player - 1][1] == length) {
                return player;
            }
        }

        return 0;
    }
}
