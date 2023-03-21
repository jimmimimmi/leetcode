package com.jimmimimmi.java.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-preorder-traversal/
/*
144. Binary Tree Preorder Traversal
Medium

1327

54

Add to List

Share
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        var dfsStack = new ArrayDeque<TreeNode>();
        TreeNode current = root;

        while (!dfsStack.isEmpty() || current != null) {
            if (current != null) {
                dfsStack.addLast(current);
                result.add(current.val); //preorder traversal
                current = current.left;
            } else {
                current = dfsStack.removeLast();
                current = current.right;
            }
        }

        return result;
    }
}
