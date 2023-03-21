package com.jimmimimmi.java.trees;

//https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2899/
/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

Input: root = [4,2,5,1,3]
Output: [1,2,3,4,5]

Explanation: The figure below shows the transformed BST.
 */

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        TreeNode[] absMinMax = new TreeNode[2];
        getMinMax(root, absMinMax);
        if (absMinMax[0] != null) {
            absMinMax[0].left = absMinMax[1];
        }
        if (absMinMax[1] != null) {
            absMinMax[1].right = absMinMax[0];
        }
        return absMinMax[0];
    }

    private TreeNode[] getMinMax(TreeNode node, TreeNode[] absMinMax) {
        if (node == null) return new TreeNode[2];
        var leftMinMax = getMinMax(node.left, absMinMax);
        var rightMinMax = getMinMax(node.right, absMinMax);

        var leftTreeMin = leftMinMax[0];
        var leftTreeMax = leftMinMax[1];

        var rightTreeMin = rightMinMax[0];
        var rightTreeMax = rightMinMax[1];

        if (absMinMax[0] == null || node.val < absMinMax[0].val) {
            absMinMax[0] = node;
        }

        if (absMinMax[1] == null || node.val > absMinMax[1].val) {
            absMinMax[1] = node;
        }

        if (leftTreeMin != null && leftTreeMin.val < absMinMax[0].val) {
            absMinMax[0] = leftTreeMin;
        } else if (leftTreeMax != null && leftTreeMax.val < absMinMax[0].val) {
            absMinMax[0] = leftTreeMax;
        }

        if (rightTreeMax != null && rightTreeMax.val > absMinMax[1].val) {
            absMinMax[1] = rightTreeMax;
        } else if (rightTreeMin != null && rightTreeMin.val > absMinMax[1].val) {
            absMinMax[1] = leftTreeMax;
        }

        if (node.val < absMinMax[0].val) absMinMax[0] = node;
        if (node.val > absMinMax[1].val) absMinMax[1] = node;

        if (leftTreeMax != null && leftTreeMax.val < node.val) {
            node.left = leftTreeMax;
            leftTreeMax.right = node;
        }
        if (rightTreeMin != null && rightTreeMin.val > node.val) {
            node.right = rightTreeMin;
            rightTreeMin.left = node;
        }

        var result = new TreeNode[]{node, node};

        if (leftTreeMin != null && leftTreeMin.val < node.val) {
            result[0] = leftTreeMin;
        }
        if (rightTreeMax != null && rightTreeMax.val > node.val) {
            result[1] = rightTreeMax;
        }


        return result;
    }
}
