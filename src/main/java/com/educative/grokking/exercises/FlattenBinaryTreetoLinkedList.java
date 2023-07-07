package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBinaryTreetoLinkedList {
    public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {
        dfs(root);
        return root;
    }


    //   5
    // 3   6    ===> 5 3 6

    //   5
    //    6    ===> 5 6

    //   5
    // 3       ===> 5 3

    // 5
    private static TreeNode<Integer> dfs(TreeNode<Integer> node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return node;
        }

        if (node.left != null && node.right != null) {
            var left = node.left;
            var right = node.right;
            var leftRightest = dfs(left);
            var rightRightest = dfs(right);
            node.left = null;
            node.right = left;
            leftRightest.right = right;
            return rightRightest;
        } else if (node.left != null) {
            var left = node.left;
            var leftRightest = dfs(left);
            node.left = null;
            node.right = left;
            return leftRightest;
        } else {
            var right = node.right;
            var rightRightest = dfs(right);
            node.left = null;
            node.right = right;
            return rightRightest;
        }
    }
}
