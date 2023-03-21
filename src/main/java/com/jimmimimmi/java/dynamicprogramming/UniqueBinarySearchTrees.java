package com.jimmimimmi.java.dynamicprogramming;

import java.util.HashMap;

//https://leetcode.com/problems/unique-binary-search-trees/
/*
96. Unique Binary Search Trees
Medium

Add to List

Share
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    //

    class LeftRight {
        private int left;
        private int right;

        LeftRight(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LeftRight leftRight = (LeftRight) o;

            if (left != leftRight.left) return false;
            return right == leftRight.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }
    }

    public int numTrees_recursively(int n) {
        counter = 0;
        return numTrees(new HashMap<>(), 1, n);
    }


    int counter = 0;

    private int numTrees(HashMap<LeftRight, Integer> cache, int left, int right) {
        var key = new LeftRight(left, right);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        counter++;

        if (left > right) {
            cache.put(key, 0);
            return 0;
        }

        if (left == right) {
            cache.put(key, 1);
            return 1;
        }

        int result = 0;
        for (int pivot = left; pivot <= right; pivot++) {
            int leftResult = numTrees(cache, left, pivot - 1);
            int rightResult = numTrees(cache, pivot + 1, right);
            if (leftResult == 0)
                result += rightResult;
            else if (rightResult == 0)
                result += leftResult;
            else result += leftResult * rightResult;
        }

        cache.put(key, result);
        return result;
    }

    public int numTrees_dp(int n) {
        var partialCosts = new int[n][n];
        for (int i = 0; i < n; i++) {
            partialCosts[i][i] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                var right = left + length - 1;

                for (int pivot = left; pivot <= right; pivot++) {
                    int leftResult = 1;
                    int rightResult = 1;

                    if (pivot > left) {
                        leftResult = partialCosts[left][pivot - 1];
                    }

                    if (pivot < right) {
                        rightResult = partialCosts[pivot + 1][right];
                    }
                    partialCosts[left][right] += leftResult * rightResult;
                }
            }
        }

        return partialCosts[0][n - 1];
    }
}
