package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode<Integer> root) {

        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        var queue = new ArrayList<TreeNode<Integer>>();
        var queueSide = new ArrayList<Boolean>();

        queue.add(root.left);
        queueSide.add(true);
        queue.add(root.right);
        queueSide.add(false);

        while (!queue.isEmpty()) {
            var size = queue.size();
            if ((size % 2) != 0) return false;
            var left = 0;
            var right = size - 1;
            while (left < right) {
                if (!queue.get(left).data.equals(queue.get(right).data)) {
                    return false;
                }
                if (queueSide.get(left) == queueSide.get(right)) {
                    return false;
                }
                left++;
                right--;
            }

            var queueInternal = new ArrayList<>(queue);
            queue.clear();
            queueSide.clear();

            for (var node: queueInternal) {
                if (node.left != null) {
                    queue.add(node.left);
                    queueSide.add(true);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    queueSide.add(false);
                }
            }
        }

        return true;
    }
}
