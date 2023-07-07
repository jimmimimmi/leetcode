package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;


// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class BinaryTreeMaximumPathSum {

    public static int maxPathSum(TreeNode<Integer> root) {

        var sb = new StringBuilder();
        var res = new int[]{Integer.MIN_VALUE};
         maxPathSumDfs(root, res);
         return res[0];
    }

    private static int maxPathSumDfs(TreeNode<Integer> node, int[] res) {

        if (node == null) return 0;

        var leftPath = Math.max(0, maxPathSumDfs(node.left, res));
        var rightPath = Math.max(0, maxPathSumDfs(node.right, res));

        var newPath = node.data + leftPath + rightPath;
        System.out.println("node " + node.data + ", leftPath " + leftPath + ", rightPath " + rightPath + ", newPath " + newPath);
        res[0] = Math.max(res[0], newPath);

        return Math.max(node.data + leftPath, node.data + rightPath);

    }

}
