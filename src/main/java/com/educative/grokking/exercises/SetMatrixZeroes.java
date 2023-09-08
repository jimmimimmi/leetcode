package com.educative.grokking.exercises;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        setMatrixZeros(matrix);
    }

    public static int[][] setMatrixZeros2(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return mat;

        var zeroRows = new boolean[mat.length];
        var zeroColumns = new boolean[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }

        for (int i = 0; i < zeroRows.length; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < mat[0].length; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < zeroColumns.length; j++) {
            if (zeroColumns[j]) {
                for (int i = 0; i < mat.length; i++) {
                    mat[i][j] = 0;
                }
            }
        }

        return mat;
    }

    public static int[][] setMatrixZeros(int[][] mat) {

        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return mat;

        var isFirstRowZero = false;
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        var isFirstColZero = false;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }


        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }


        for (int j = 1; j < mat[0].length; j++) {
            if (mat[0][j] == 0) {
                for (int i = 0; i < mat.length; i++) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < mat.length; i++) {
            if (mat[i][0] == 0) {
                for (int j = 0; j < mat[0].length; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        if (isFirstColZero) {
            for (int i = 0; i < mat.length; i++) {
                mat[i][0] = 0;
            }
        }

        if (isFirstRowZero) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[0][j] = 0;
            }
        }

        return mat;
    }
}
