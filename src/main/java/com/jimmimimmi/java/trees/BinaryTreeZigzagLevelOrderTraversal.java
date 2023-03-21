package com.jimmimimmi.java.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
/*
103. Binary Tree Zigzag Level Order Traversal
Medium

1761

90

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
Accepted
332,631
Submissions
720,787
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var levelQueue = new ArrayDeque<TreeNode>();
        var levelStack = new ArrayDeque<TreeNode>();
        var result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        levelQueue.addLast(root);
        boolean inverse = true;

        while (!levelQueue.isEmpty()) {
            var levelSize = levelQueue.size();
            var levelResult = new ArrayList<Integer>();
            result.add(levelResult);

            for (int i = 0; i < levelSize; i++) {
                var node = levelQueue.removeFirst();
                levelResult.add(node.val);
                levelStack.addLast(node);
            }

            while (!levelStack.isEmpty()) {
                var node = levelStack.removeLast();
                if (inverse) {
                    if (node.right != null) levelQueue.addLast(node.right);
                    if (node.left != null) levelQueue.addLast(node.left);
                } else {
                    if (node.left != null) levelQueue.addLast(node.left);
                    if (node.right != null) levelQueue.addLast(node.right);
                }
                inverse = !inverse;
            }
        }

        return result;
    }
}
