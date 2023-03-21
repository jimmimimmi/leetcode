package com.jimmimimmi.java.matrix;

//https://leetcode.com/articles/search-a-2d-matrix-ii/

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

 */

import java.util.Optional;

public class Search2DMatrix_BinarySearch {

    private boolean binarySearch(int[][] matrix, int target, Optional<Integer> row, Optional<Integer> column) {
        var low = 0;
        var high = row
                .map(rowIdx -> matrix[0].length - 1)
                .orElseGet(() -> matrix.length - 1);

        while (low <= high) {
            var mid = low + (high - low) / 2;
            var midCell = row.map(rowIdx -> matrix[rowIdx][mid]).orElseGet(() -> matrix[mid][column.get()]);

            if (midCell == target) return true;
            else if (midCell > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        var n = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < n; i++) {
            var rowSearchResult = binarySearch(matrix, target, Optional.of(i), Optional.empty());
            if (rowSearchResult) return true;
            var columnSearchResult = binarySearch(matrix, target, Optional.empty(), Optional.of(i));
            if (columnSearchResult) return true;
        }
        return false;
    }
}
