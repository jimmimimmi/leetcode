package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;
import junit.framework.TestCase;

import java.util.List;

public class BinaryTreeMaximumPathSumTest extends TestCase {

    public void testMaxPathSum() {
        System.out.println(BinaryTreeMaximumPathSum.maxPathSum(TreeNode.fromList(List.of(7, 3, 4, -1, -3))));
    }
}