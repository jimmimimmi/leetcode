package com.jimmimimmi.java.dynamicprogramming;

import junit.framework.TestCase;

public class SubsetSumProblemTest extends TestCase {

    public void testCanGetSubsetEqualTo() {
        assertTrue(new SubsetSumProblem().canGetSubsetEqualTo(8, new int[]{1, 2, 4, 5, 6}));
        assertTrue(new SubsetSumProblem().canGetSubsetEqualTo(7, new int[]{1, 2, 4, 5, 6}));
        assertFalse(new SubsetSumProblem().canGetSubsetEqualTo(10, new int[]{3, 4, 5, 8, 9}));
    }
}