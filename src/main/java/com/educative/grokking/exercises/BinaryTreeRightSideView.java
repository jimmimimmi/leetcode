package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        var result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        var queue = new ArrayDeque<TreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()){
            var size = queue.size();
            for (int i = 1; i <= size; i++) {
                var node = queue.poll();
                if (i == size) {
                    result.add(node.data);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return result;
    }
}
