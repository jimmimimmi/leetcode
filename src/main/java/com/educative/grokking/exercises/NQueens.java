package com.educative.grokking.exercises;

import java.util.*;

/*
Given a chessboard of size n×n, determine how many ways
n  queens can be placed on the board, such that no two queens attack each other.

A queen can move horizontally, vertically, and diagonally on a chessboard.
One queen can be attacked by another queen if both share the same row, column, or diagonal.
 */
public class NQueens {
    private static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
        int oldRow = 0, oldCol = 0, diagonalOffset = 0;
        for (int i = 0; i < proposedRow; i++) {
            oldRow = i;
            oldCol = solution.get(i);
            diagonalOffset = proposedRow - oldRow;

            if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol + diagonalOffset) {
                return false;
            }
        }

        return true;
    }


    public static int solveNQueensWithStack(int n) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> solution = new ArrayList<>(Collections.nCopies(n, -1));
        var stack = new Stack<Integer>();

        var col = 0;
        var row = 0;
        while (row < n) {
            while (col < n) {
                var isValid = isValidMove(row, col, solution);
                if (isValid) {
                    solution.set(row, col);
                    stack.push(col);
                    col = 0;
                    row++;
                    break;
                } else {
                    col++;
                }
            }
            if (col == n) { // we did not find a safe place within the row #row
                if (!stack.empty()) {
                    var prevCol = stack.pop(); // column for the (row-1)
                    col = prevCol + 1;
                    row--;
                } else {
                    break;
                }
            }
            if (row == n) {
                results.add(new ArrayList<>(stack));
                var prevCol = stack.pop(); // column for the (row-1)
                col = prevCol + 1;
                row--;
            }
        }

        return results.size();
    }

    private static void explore(int n, ArrayList<Integer> solution, ArrayList<List<Integer>> results, int row) {
        if (row == n) {
            results.add(new ArrayList<>(solution));
            return;
        }

        for (int col = 0; col < n; col++) {
            var isValid = isValidMove(row, col, solution);
            if (isValid) {
                var prev = solution.get(row);
                solution.set(row, col);
                explore(n, solution, results, row + 1);
                solution.set(row, prev);
            }
        }
    }

    public static int countNQueensResults(int n) {
        var result = new ArrayList<List<Integer>>();
        var solution = new ArrayList<Integer>(Collections.nCopies(n, -1));
        explore(n, solution, result, 0);
        return result.size();
    }

    public static List<List<String>> printNQueens(int n) {
        var result = new ArrayList<List<Integer>>();
        var solution = new ArrayList<Integer>(Collections.nCopies(n, -1));
        explore(n, solution, result, 0);

        var stringResult = new ArrayList<List<String>>();
        for (var sol : result) {
            var rows = new ArrayList<String>();
            for (Integer column : sol) {
                var chars = new char[n];
                Arrays.fill(chars, '.');
                chars[column] = 'Q';
                rows.add(new String(chars));
            }
            stringResult.add(rows);
        }

        return stringResult;
    }

}
