package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class NumberOfIslandsTest extends TestCase {

    public void testNumIslands() {
//        System.out.println(NumberOfIslands.numIslands(new char[][]{
//                {'1', '1', '1'},
//                {'0', '1', '0'},
//                {'1', '0', '0'},
//                {'1', '0', '1'},
//        }));
        System.out.println(NumberOfIslands.numIslands(new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'},
        }));
    }
}