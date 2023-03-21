package com.jimmimimmi.java.trees;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        //add (root.left); add (root.right); add (root)
        var result = new ArrayDeque<Integer>();

        var stack = new ArrayDeque<TreeNode>();
        var current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.addLast(current);
                result.addFirst(current.val);
                current = current.right;
            } else {
                current = stack.removeLast();
                current = current.left;
            }
        }
        return new ArrayList<>(result);
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        var result = new ArrayList<Integer>();
        explore(root, result);
        return result;
    }

    private void explore(TreeNode node, List<Integer> result) {
        if (node == null) return;
        explore(node.left, result);
        explore(node.right, result);
        result.add(node.val);
    }
}
