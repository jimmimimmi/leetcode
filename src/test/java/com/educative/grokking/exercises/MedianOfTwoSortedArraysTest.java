package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class MedianOfTwoSortedArraysTest extends TestCase {

    public void testFindMedianSortedArrays() {
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(
                new int[]{1, 5},
                new int[]{2, 3, 4}
        ));
    }
}