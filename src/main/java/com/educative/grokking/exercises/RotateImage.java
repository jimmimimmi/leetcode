package com.educative.grokking.exercises;


/*

1   2   3   4
5   6   7   8
9   10  11  12
13  14  15  16

13  9    5   1
14  10   6   2
15  11   7   3
16  12   8   4


(0,0) -> (0,3) -> (3,3) -> (3,0)
(0,1) -> (1,3) -> (3,2) -> (2,0)
(0,2) -> (2,3) -> (3,1) -> (1,0)


1   2   3
4   5   6
7   8   9


7   5   1
8   5   2
9   6   3




 */

// https://leetcode.com/problems/rotate-image/description/

public class RotateImage {
    public static int[][] rotateImage(int[][] matrix) {

        if (matrix == null || matrix.length <= 1) {
            return matrix;
        }

        var top = 0;

        var bottom = matrix.length - 1;

        while (top < bottom) {
            for (int i = 0; i < bottom - top; i++) {
                var a = matrix[top][top + i];
                var b = matrix[top + i][bottom];
                var c = matrix[bottom][bottom - i];
                var d = matrix[bottom - i][top];

                matrix[top + i][bottom] = a;
                matrix[bottom][bottom - i] = b;
                matrix[bottom - i][top] = c;
                matrix[top][top + i] = d;
            }
            top++;
            bottom--;
        }

        return matrix;
    }

}
