package com.jimmimimmi.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/combination-sum/
/*
39. Combination Sum
Medium
Add to List

Share
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();

        explore(candidates, 0, new ArrayList<Integer>(), target, result);
        return result;
    }

    private void explore(int[] candidates, int currentIdx, ArrayList<Integer> subResult, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = currentIdx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                subResult.add(candidates[i]);
                int subResultLength = subResult.size();
                explore(candidates, i, subResult, target - candidates[i], result);
                subResult.remove(subResultLength - 1);
            }
        }
    }
}
