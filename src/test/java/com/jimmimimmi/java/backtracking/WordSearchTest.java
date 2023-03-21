package com.jimmimimmi.java.backtracking;

import junit.framework.TestCase;

public class WordSearchTest extends TestCase {
    public void testName() {
//        new WordSearch().exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}}, "SEE");

        new WordSearch().exist(new char[][]{
                {'A', 'A'}}, "AAA");
    }
}