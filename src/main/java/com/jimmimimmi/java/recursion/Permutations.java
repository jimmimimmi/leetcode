package com.jimmimimmi.java.recursion;

//https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2903/

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        if (nums.length <= 0) {
            var result = new ArrayList<List<Integer>>();
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return result;
        }
        var result = new ArrayList<List<Integer>>();
        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int tempStart = nums[start];
            nums[start] = nums[i];
            nums[i] = tempStart;

            permute(nums, start + 1, result);

            nums[i] = nums[start];
            nums[start] = tempStart;
        }
    }
}
