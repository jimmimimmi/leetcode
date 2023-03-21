package com.jimmimimmi.java.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        var stack = new Stack<TreeNode>();
        var result = new ArrayList<Integer>();
        TreeNode current = root;

        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }
}
