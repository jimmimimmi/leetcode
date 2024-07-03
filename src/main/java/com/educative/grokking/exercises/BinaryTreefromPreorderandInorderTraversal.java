package com.educative.grokking.exercises;


import com.educative.grokking.templates.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class BinaryTreefromPreorderandInorderTraversal {
    /*
        preorder = [1, 12, 15, 6, 9, 5, 2]
        inorder = [15, 12, 6, 1, 5, 9, 2]
            1
           /  \
          12   9
         / \  / \
        15  6 5  2

      [1, 12, 15, 6, 9, 5, 2]
      [15, 12, 6, 1, 5, 9, 2]
      1
        left:
            [12, 15, 6]
            [15, 12, 6]
            12
                left:
                    [15]
                    [15]
                    15
                right:
                    [6]
                    [6]
                    6
        right:
            [

        preorder = [1, 2, 4, 7, 3]
        inorder = [4, 2, 7, 1, 3]
               1
              / \
             2   3
            / \
           4   7


     */


    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {
        if (pOrder == null || iOrder == null || iOrder.length != pOrder.length || iOrder.length == 0) {
            return null;
        }

        var inorderValueToIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < iOrder.length; i++) {
            inorderValueToIndexMap.put(iOrder[i], i);
        }

        return build(0, pOrder.length - 1, new int[]{0}, pOrder, inorderValueToIndexMap);
    }

    private static TreeNode build(int left, int right, int[] currIdx, int[] pOrder, HashMap<Integer, Integer> iOrderMap) {
        if (left > right) {
            return null;
        }

        var curr = currIdx[0];
        currIdx[0] = curr + 1;
        var nodeVal = pOrder[curr];
        var mid = iOrderMap.get(nodeVal);
        var node = new TreeNode(nodeVal);
        if (left != right) {
            node.left = build(left, mid - 1, currIdx, pOrder, iOrderMap);
            node.right = build(mid + 1, right, currIdx, pOrder, iOrderMap);
        }
        return node;
    }
}
