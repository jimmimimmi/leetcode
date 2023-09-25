package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

import java.util.ArrayList;

// https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree {
    public static boolean validateBst(TreeNode<Integer> root) {

        var prev = new Integer[]{null, 1};
        preOrder(root, prev);
        return prev[0] == 1;
    }

    private static void preOrder(TreeNode<Integer> node, Integer[] prev) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            preOrder(node.left, prev);
        }

        if (prev[1] == 0) {
            return;
        }

        if (prev[0] >= node.data) {
            prev[0] = null;
            prev[1] = 0;
        } else {
            prev[0] = node.data;
        }

        if (node.right != null) {
            preOrder(node.right, prev);
        }
    }
}
