package com.jimmimimmi.java.matrix;

import java.util.ArrayDeque;

public class Search2DMatrix_DevideAndConquer {

    private boolean explore(int[][] matrix, int target, int x0, int y0, int x1, int y1) {
        if (x1 == x0 && y1 == y0) return matrix[x1][y1] == target;
        if (x1 < x0 || y1 < y0) return false;

        if (matrix[x0][y0] > target) return false;
        if (matrix[x1][y1] < target) return false;

        var midY = y0 + (y1 - y0) / 2;
        var midX = x0 + (x1 - x0) / 2;

        if (matrix[midX][midY] == target) return true;

        var leftTopRes = explore(matrix, target, x0, y0, midX, midY);
        var rightTopRes = explore(matrix, target, x0, midY + 1, midX, y1);

        var leftBottomRes = explore(matrix, target, midX + 1, y0, x1, midY);
        var rightBottomRes = explore(matrix, target, midX + 1, midY + 1, x1, y1);

        return leftTopRes || rightTopRes || leftBottomRes || rightBottomRes;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        return explore(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
}
