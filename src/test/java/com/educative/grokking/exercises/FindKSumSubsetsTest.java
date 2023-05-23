package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.List;

public class FindKSumSubsetsTest extends TestCase {

    public void testGetKSumSubsets() {
        System.out.println( FindKSumSubsets.getKSumSubsets2(List.of(8,13,3,22,17,39,87,45,36), 135));
    }
}