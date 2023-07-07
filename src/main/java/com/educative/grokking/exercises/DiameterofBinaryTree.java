package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterofBinaryTree {
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        // Write your code here
        var maxDiameter = new int[]{-1};
        getHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    private static int getHeight(TreeNode<Integer> root, int[] maxDiameter) {
        if (root == null) {
            return 0;
        }
        var leftHeight = getHeight(root.left, maxDiameter);
        var rightHeight = getHeight(root.right, maxDiameter);

        var diameter = leftHeight + rightHeight;
        if (maxDiameter[0] < diameter) {
            maxDiameter[0] = diameter;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
