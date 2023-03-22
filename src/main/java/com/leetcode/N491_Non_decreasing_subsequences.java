package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given an integer array nums,
return all the different possible non-decreasing subsequences of the given array
with at least two elements. You may return the answer in any order.



Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

[[7,7],[6,7],[6,7],[6,7,7],[4,7],[4,7],[4,7,7],[4,6],[4,6,7],[4,6,7],[4,6,7,7]]

Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]


Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100
 */
public class N491_Non_decreasing_subsequences {
    public List<List<Integer>> findSubsequencesNoRecursion(int[] nums) {
        if (nums.length == 0) return List.of();

        var allSubsequences = new HashSet<List<Integer>>();
        for (int i = nums.length - 1; i >= 0; i--) {
            var num = nums[i];
            var self = new ArrayList<Integer>();
            self.add(num);
            var newSubsequences = allSubsequences.stream().filter(list -> list.get(0) >= num).map(list -> {
                var subsequence = new ArrayList<Integer>(list.size() + 1);
                subsequence.add(num);
                subsequence.addAll(list);
                return subsequence;
            }).collect(Collectors.toList());
            allSubsequences.add(self);
            allSubsequences.addAll(newSubsequences);
        }

        return allSubsequences.stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return List.of();

        var allSubsequences = new HashSet<List<Integer>>();
        for (int j = 0; j < nums.length; j++) {
            process(nums, allSubsequences, j, new ArrayList<>());
        }
        return new ArrayList<>(allSubsequences);
    }

    private void process(int[] nums, Set<List<Integer>> result, int i, List<Integer> subresult) {
        boolean shouldRemove = false;
        if (subresult.size() == 0 || subresult.get(subresult.size() - 1) <= nums[i]) {
            subresult.add(nums[i]);
            shouldRemove = true;
        }
        if (subresult.size() > 1) {
            result.add(new ArrayList<>(subresult));
        }
        for (int j = i + 1; j < nums.length; j++) {
            process(nums, result, j, subresult);
        }
        if (shouldRemove) subresult.remove(subresult.size() - 1);
    }
}
