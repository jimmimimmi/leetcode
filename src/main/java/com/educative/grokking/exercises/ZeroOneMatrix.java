package com.educative.grokking.exercises;

// https://leetcode.com/problems/01-matrix/description/
public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return mat;

        var rows = mat.length;
        var cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    int up = (i > 0) ? mat[i - 1][j] : Integer.MAX_VALUE - 10000;
                    int left = (j > 0) ? mat[i][j - 1] : Integer.MAX_VALUE - 10000;

                    mat[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int down = (i < rows - 1) ? mat[i + 1][j] : Integer.MAX_VALUE - 10000;

                    int right = (j < cols - 1) ? mat[i][j + 1] : Integer.MAX_VALUE - 10000;

                    mat[i][j] = Math.min(mat[i][j], Math.min(down + 1, right + 1));
                }
            }
        }

        return mat;

        /*
        [1, 1, 1, 1],
        [1, 0, 1, 0],
        [1, 1, 1, 1],
        [0, 0, 0, 0]

        [2, 1, 2, 1],
        [1, 0, 1, 0],
        [1, 1, 1, 1],
        [0, 0, 0, 0]
         */

        // 1 0 1
        // 0 1 1
        // 0 1 1

        // 1 0 1 1 1
        // 0 1 1 1 1
        // 0 1 1 1 1
        // 0 1 1 1 1
        // 0 1 1 0 1


        // 1 0 1 2 3
        // 0 1 2 3 4
        // 0 1 2 2 3
        // 0 1 2 1 2
        // 0 1 1 0 1


        // Replace this placeholder return statement with your code


        // 1,20,30,5,7,8,9,40,100

        // x,20,30,5,7,8,9,40,100
            // x,20,x,5,7,8,9,40,100
                // x,20,x,5,x,8,9,40,100
                // x,20,x,x,7,8,9,40,100
            // x,x,30,5,7,8,9,40,100

        // 1,x,30,5,7,8,9,40,x

    }
}
