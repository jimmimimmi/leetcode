package com.jimmimimmi.java.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://leetcode.com/problems/subsets/
/*
78. Subsets
Medium

Add to List

Share
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) return result;
        List<List<Integer>>[] cache = new List[nums.length];
        for (int i = 0; i < nums.length; i++) {
            var subresult = subsets(nums, i, cache);
            result.addAll(subresult);
        }

        return result;
    }

    public List<List<Integer>> subsets(int[] nums, int startIdx, List<List<Integer>>[] cache) {
        if (cache[startIdx] != null) return cache[startIdx];
        var results = new ArrayList<List<Integer>>();
        for (int i = startIdx + 1; i < nums.length; i++) {
            var rightResults = subsets(nums, i, cache);
            rightResults.forEach(l ->
                    {
                        var subArrayCopy = new ArrayList<Integer>(l);
                        subArrayCopy.add(0, nums[startIdx]);
                        results.add(subArrayCopy);
                    }
            );
        }
        var self = new ArrayList<Integer>();
        self.add(nums[startIdx]);
        results.add(self);
        cache[startIdx] = results;
        return results;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(
                        new ArrayList<Integer>(curr) {{
                            add(num);
                        }}
                );
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }


    public void backtrack(int first, int k, ArrayList<Integer> curr, List<List<Integer>> output, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList<>(curr));

        for (int i = first; i < nums.length; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, k, curr, output, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets3(int[] nums) {
        var output = new ArrayList<List<Integer>>();
        for (int k = 0; k < nums.length + 1; ++k) {
            backtrack(0, k, new ArrayList<Integer>(), output, nums);
        }
        return output;
    }

    public List<List<Integer>> subsets_binary(int[] nums) {
        var output = new ArrayList<List<Integer>>();
        for (int i = 1 << nums.length; i < 1 << nums.length + 1; i++) {
            String mask = Integer.toBinaryString(i).substring(1);
            ArrayList<Integer> subResult = new ArrayList<>();
            for (int j = 0; j < mask.length(); j++) {
                if (mask.charAt(j) == '1') subResult.add(nums[j]);
            }
            output.add(subResult);
        }
        return output;
    }

}
