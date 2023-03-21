package com.jimmimimmi.java.dynamicprogramming;

import junit.framework.TestCase;

public class KnapsackProblem01Test extends TestCase {

    public void testGetMaximumWeight() {
        var val = new int[]{22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        var weights = new int[]{4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        var maxWeight = 30;
        var result1 = new KnapsackProblem01().getMaximumWeight_bottomUpDp(val, weights, maxWeight);
        var result2 = new KnapsackProblem01().getMaximumWeight_recursive(val, weights, maxWeight);

        System.out.println(result1);
        System.out.println(result2);
    }
}