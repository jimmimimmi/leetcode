package com.jimmimimmi.java.recursion;

import junit.framework.TestCase;

public class LargestRectangleInHistogramTest extends TestCase {

    public void testLargestRectangleArea() {

        var res1 = new LargestRectangleInHistogram().largestRectangleArea(new int[]{0, 2, 0});
        var res2 = new LargestRectangleInHistogram_stack().largestRectangleArea(new int[]{0, 2, 0});

        assertEquals(res1, res2);
    }
}