package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class BinaryTreefromPreorderandInorderTraversalTest extends TestCase {

    public void testBuildTree() {
        BinaryTreefromPreorderandInorderTraversal.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}