package com.jimmimimmi.java.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        if (root == null) return result;
        queue.push(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            var levelResult = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var node = queue.pop();
                levelResult.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            result.add(levelResult);
        }

        return result;
    }
}
