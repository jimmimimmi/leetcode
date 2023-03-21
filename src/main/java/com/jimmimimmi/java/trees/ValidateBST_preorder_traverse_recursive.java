package com.jimmimimmi.java.trees;

public class ValidateBST_preorder_traverse_recursive {
    public boolean isValidBST(TreeNode root) {
        return getPrev(root, new Integer[]{null});
    }

    private boolean getPrev(TreeNode node, Integer[] prev) {
        if (node == null) return true;
        var left = getPrev(node.left, prev);
        if (!left) return false;
        if (prev[0] != null && node.val <= prev[0]) return false;
        prev[0] = node.val;
        return getPrev(node.right, prev);
    }
}
