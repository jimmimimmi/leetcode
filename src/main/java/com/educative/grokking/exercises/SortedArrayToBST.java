package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

public class SortedArrayToBST {
    public static TreeNode<Integer> sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode<Integer> build(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }
        if (left == right) {
            return new TreeNode<Integer>(nums[left]);
        }

        var mid = left + (right - left) / 2;

        var node = new TreeNode<Integer>(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);

        return node;
    }
}
