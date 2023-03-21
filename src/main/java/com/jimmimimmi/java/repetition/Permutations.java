package com.jimmimimmi.java.repetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        if (nums.length == 1) {
            var subResult = new ArrayList<Integer>();
            subResult.add(nums[0]);
            var result = new ArrayList<List<Integer>>();
            result.add(subResult);
            return result;
        }

        var result = new ArrayList<List<Integer>>();
        exlore(nums, 0, result);
        return result;
    }

    private void exlore(int[] nums, int currentIdx, List<List<Integer>> result) {
        if (currentIdx == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = currentIdx; i < nums.length; i++) {
            var temp = nums[i];
            nums[i] = nums[currentIdx];
            nums[currentIdx] = temp;

            exlore(nums, currentIdx + 1, result);

            nums[currentIdx] = nums[i];
            nums[i] = temp;
        }
    }
}
