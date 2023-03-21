package com.jimmimimmi.java.trees;

import java.util.LinkedList;

public class ValidateBST_preorder_traverse_iterative {
    public boolean isValidBST(TreeNode root) {
        var stack = new LinkedList<TreeNode>();
        var current = root;
        Integer prev = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (prev != null && current.val <= prev) return false;
                prev = current.val;
                current = current.right;
            }
        }
        return true;
    }

}
