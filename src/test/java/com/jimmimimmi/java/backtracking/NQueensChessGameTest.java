package com.jimmimimmi.java.backtracking;

import junit.framework.TestCase;

public class NQueensChessGameTest extends TestCase {
    public void testName() {
        var suite = new NQueensChessGame();
        assertEquals(2, suite.totalNQueens(4));
        assertEquals(0, suite.totalNQueens(3));
    }
}