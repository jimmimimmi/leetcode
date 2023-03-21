package com.jimmimimmi.java.trees;

import junit.framework.TestCase;

public class ValidateBST_preorder_traverse_recursiveTest extends TestCase {
    public void testName() {
        new ValidateBST_preorder_traverse_recursive().isValidBST(BinarySearchFactory.Create(new Integer[]{2, 1, 3}));
    }

    public void test2(){
        new GridenvSolution().solution(100, new int[]{10, 6, 6, 8}, 2);
    }
}