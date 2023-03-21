package com.jimmimimmi.java.backtracking;

//https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations {

    private void explore(int n, int k, int current, List<List<Integer>> result, List<Integer> subResult) {

        if (subResult.size() == k) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = current; i <= n - (k - subResult.size()) + 1 ; i++) {
            subResult.add(i);
            explore(n, k, i + 1, result, subResult);
            subResult.remove(subResult.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        var result = new ArrayList<List<Integer>>();
        explore(n, k, 1, result, new ArrayList<Integer>());
        return result;
    }
}
