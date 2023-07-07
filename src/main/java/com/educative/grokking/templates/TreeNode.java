package com.educative.grokking.templates;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static <T> TreeNode<T> fromList(List<T> list) {

        return fromList(list, 0);
    }

    private static <T> TreeNode<T> fromList(List<T> list, int i) {
        TreeNode<T> root = null;
        // Base case for recursion
        if (i < list.size()) {
            root = new TreeNode<T>(list.get(i));

            // insert left child
            root.left = fromList(list, 2 * i + 1);

            // insert right child
            root.right = fromList(list, 2 * i + 2);
        }
        return root;
    }
}
