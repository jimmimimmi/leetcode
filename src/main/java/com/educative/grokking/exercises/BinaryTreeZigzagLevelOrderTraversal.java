package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
   /*
                                     A
                     B                                  C
        D                      E                 F              G
     H    I                 J   K             L   M          N    O

   A -> C, B -> D, E, F, G -> O, N, M, L, K, J, I, H

    */


    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {


        var result = new ArrayList<List<Integer>>();


        if (root == null) {
            return result;
        }
        var forward = true;
        var queue = new ArrayDeque<TreeNode<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            var subarray = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node != null) {
                    if (forward) {
                        subarray.add(node.data);
                    } else {
                        subarray.add(0, node.data);
                    }
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            if (!subarray.isEmpty()) {
                result.add(subarray);
            }
            forward = !forward;
        }
        return result;
    }
}
