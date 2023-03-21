package com.jimmimimmi.java.trees;

import java.util.LinkedList;

public class ValidateBST_iterative {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        var stack = new LinkedList<TreeNode>();
        var boundaries = new LinkedList<Integer[]>();

        stack.push(root);
        boundaries.push(new Integer[]{null, null});

        while (!stack.isEmpty()) {
            var current = stack.pop();
            var bound = boundaries.pop();
            if (current == null) continue;

            if (bound[0] != null && current.val <= bound[0]) return false;
            if (bound[1] != null && current.val >= bound[1]) return false;

            stack.push(current.right);
            boundaries.push(new Integer[]{current.val, bound[1]});

            stack.push(current.left);
            boundaries.push(new Integer[]{bound[0], current.val});
        }
        return true;

    }
}
