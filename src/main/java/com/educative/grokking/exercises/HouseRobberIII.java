package com.educative.grokking.exercises;


import com.educative.grokking.templates.TreeNode;

import java.util.HashMap;

/*
A thief has discovered a new neighborhood to target, where the houses can be represented as nodes in a binary tree.
The money in the house is the data of the respective node.
The thief can enter the neighborhood from a house represented as root of the binary tree.
Each house has only one parent house.
The thief knows that if he robs two houses that are directly connected, the police will be notified.
The thief wants to know the maximum amount of money he can steal from the houses without getting caught by the police.
The thief needs your help determining the maximum amount of money he can rob without alerting the police.
 */
public class HouseRobberIII {
    public static int rob(TreeNode<Integer> root) {
        var exploreResult = explore(root);
        return Math.max(exploreResult[0], exploreResult[1]);
    }

    private static int[] explore(TreeNode<Integer> root) {

        if (root == null) return new int[]{0, 0};

        var leftExplore = explore(root.left);
        var rightExplore = explore(root.right);

        var includeResult = root.data + leftExplore[1] + rightExplore[1];
        var excludeResult = Math.max(leftExplore[0], leftExplore[1]) + Math.max(rightExplore[0], rightExplore[1]);

        return new int[]{includeResult, excludeResult};
    }
}
