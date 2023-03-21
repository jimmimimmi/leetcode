package com.jimmimimmi.java.trees;


import java.util.ArrayList;

public class BinarySearchFactory {
    public static TreeNode Create(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);

        var treeNodes = new ArrayList<TreeNode>(array.length / 2);
        treeNodes.add(root);
        int index = 0;
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.remove(0);
            index++;
            if (index < array.length) {
                Integer leftValue = array[index];
                if (leftValue != null) {
                    TreeNode leftNode = new TreeNode(leftValue);
                    treeNodes.add(leftNode);
                    current.left = leftNode;
                } else {
                    current.left = null;
                }

                index++;
                Integer rightValue = array[index];
                if (rightValue != null) {
                    TreeNode rightNode = new TreeNode(rightValue);
                    treeNodes.add(rightNode);
                    current.right = rightNode;
                } else {
                    current.right = null;
                }
            }

        }
        return root;
    }
}
