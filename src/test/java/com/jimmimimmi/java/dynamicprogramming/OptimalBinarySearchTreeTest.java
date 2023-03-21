package com.jimmimimmi.java.dynamicprogramming;

import junit.framework.TestCase;

public class OptimalBinarySearchTreeTest extends TestCase {

    public void testGetMinCost_recursive() {
        var recursiveResult1 = new OptimalBinarySearchTree().getMinCost_recursive(new int[]{10, 12, 16, 21}, new int[]{4, 2, 6, 3});
        var dpResult1 = new OptimalBinarySearchTree().getMinCost_dp(new int[]{10, 12, 16, 21}, new int[]{4, 2, 6, 3});
        System.out.println("recursiveResult1 " + recursiveResult1);
        System.out.println("dpResult1 " + dpResult1);
        assertEquals(26, recursiveResult1);
        assertEquals(26, dpResult1);

        var recursiveResult2 = new OptimalBinarySearchTree().getMinCost_recursive(new int[]{10, 12, 20, 35, 46}, new int[]{34, 8, 50, 21, 16});
        var dpResult2 = new OptimalBinarySearchTree().getMinCost_dp(new int[]{10, 12, 20, 35, 46}, new int[]{34, 8, 50, 21, 16});

        System.out.println("recursiveResult2 " + recursiveResult2);
        System.out.println("dpResult2 " + dpResult2);
        assertEquals(recursiveResult2, dpResult2);

    }
}