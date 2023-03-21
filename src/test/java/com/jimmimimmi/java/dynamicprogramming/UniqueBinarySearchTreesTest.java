package com.jimmimimmi.java.dynamicprogramming;

import junit.framework.TestCase;

public class UniqueBinarySearchTreesTest extends TestCase {

    public void testNumTrees_recursively() {
        var result3_recuresive = new UniqueBinarySearchTrees().numTrees_recursively(3);
        var result3_dp = new UniqueBinarySearchTrees().numTrees_recursively(3);
        System.out.println("result3_dp " + result3_dp);
        assertEquals(result3_recuresive, result3_dp);

        var result5_recuresive = new UniqueBinarySearchTrees().numTrees_recursively(5);
        var result5_dp = new UniqueBinarySearchTrees().numTrees_recursively(5);
        System.out.println("result5_dp " + result5_dp);
        assertEquals(result5_recuresive, result5_dp);

        var result8_recuresive = new UniqueBinarySearchTrees().numTrees_recursively(8);
        var result8_dp = new UniqueBinarySearchTrees().numTrees_recursively(8);
        System.out.println("result8_dp " + result8_dp);
        assertEquals(result8_recuresive, result8_dp);

        var result11_recuresive = new UniqueBinarySearchTrees().numTrees_recursively(11);
        var result11_dp = new UniqueBinarySearchTrees().numTrees_recursively(11);
        System.out.println("result11_dp " + result11_dp);
        assertEquals(result11_recuresive, result11_dp);
    }
}