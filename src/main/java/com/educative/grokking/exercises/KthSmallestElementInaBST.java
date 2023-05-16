package com.educative.grokking.exercises;

import com.educative.grokking.templates.BinaryTreeNode;

import java.util.ArrayList;

public class KthSmallestElementInaBST {
    public static int kthSmallestElement(BinaryTreeNode root, int k) {
        var elements = new ArrayList<Integer>();
        inOrderTraversal(root, elements);

        return elements.get(Math.min(k, elements.size()) - 1);
    }

    private static void inOrderTraversal(BinaryTreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    }
}
