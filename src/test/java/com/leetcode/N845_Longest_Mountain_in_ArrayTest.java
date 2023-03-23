package com.leetcode;

import junit.framework.TestCase;

public class N845_Longest_Mountain_in_ArrayTest extends TestCase {

    public void testLongestMountain() {
        System.out.println(N845_Longest_Mountain_in_Array.longestMountain(new int[]{2, 2, 2}));
        System.out.println(N845_Longest_Mountain_in_Array.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(N845_Longest_Mountain_in_Array.longestMountain(new int[]{2, 1, 4, 4, 5, 2}));
    }
}