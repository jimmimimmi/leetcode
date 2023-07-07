package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenBinaryTreetoLinkedListTest extends TestCase {

    public void testFlattenTree() {
        FlattenBinaryTreetoLinkedList.flattenTree(TreeNode.fromList(new ArrayList<>(List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}))));
    }
}