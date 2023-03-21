package com.jimmimimmi.java.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node != null) {
            traverse(node.left, result);
            result.add(node.val);
            traverse(node.right, result);
        }
    }
}
