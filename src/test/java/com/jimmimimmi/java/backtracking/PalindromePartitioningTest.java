package com.jimmimimmi.java.backtracking;

import junit.framework.TestCase;

import java.util.List;

public class PalindromePartitioningTest extends TestCase {

    public void testPartition() {
        List<List<String>> aab = new PalindromePartitioning().partition("aabaa");
    }
}