package com.jimmimimmi.java.matrix;

import junit.framework.TestCase;

public class Search2DMatrix_BinarySearchTest extends TestCase {

    public void testSearchMatrix() {
        var res1 = new Search2DMatrix_BinarySearch().searchMatrix(
                new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30},
                }, 9
        );
        assertTrue(res1);
    }
}