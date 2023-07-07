package com.educative.grokking.exercises;

import com.educative.grokking.templates.EduTreeNode;

import java.util.ArrayDeque;

public class ConnectAllSiblingsofaBinaryTree {
    public static void populateNextNodePointers(EduTreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        var queue = new ArrayDeque<EduTreeNode<Integer>>();
        queue.offer(node);
        EduTreeNode<Integer> prev = null;
        while (!queue.isEmpty()){
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var curr = queue.poll();
                if (prev != null){
                    prev.next = curr;
                }
                prev = curr;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
    }
}
