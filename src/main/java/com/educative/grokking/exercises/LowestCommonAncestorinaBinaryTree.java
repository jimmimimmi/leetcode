package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestorinaBinaryTree {

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        return explore(root, p, q);
    }

    private static TreeNode<Integer> explore(TreeNode<Integer> node, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (node == null) {
            return null;
        }
        if (node.data.equals(p.data) || node.data.equals(q.data)) {
            return node;
        }

        var leftLCA = explore(node.left, p, q);
        var rightLCA = explore(node.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return node;
        } else {
            return leftLCA != null ? leftLCA : rightLCA;
        }

    }
}
