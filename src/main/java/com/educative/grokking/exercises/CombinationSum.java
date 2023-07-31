package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {

    // 3,7,4,9 |  12 => 3,3,3,3 | 4,4,4 | 3,9

    // (3) + calc ([3,7,4,9])
    // (3) + calc ([7,4,9])
    // (3) + calc ([4,9])
    // (3) + calc ([9])

    // (3) + calc ([3,7,4,9])

    /*
    3 => 3,7,4,9  | 9
     (3 -> 3) => 3,7,4,9  | 6
        (3 -> 3 -> 3) => 3,7,4,9  | 3
            (3 -> 3 -> 3 -> 3) => 3,7,4,9  | -1
        (3 -> 3 -> 3) => 7,4,9  | 3


    // 7,4,9 |  12 =>
    (7) ->



      0,  1, 2,  3,  4, 5, 6,    7,             8,      9          , 10                   , 11                            ,12
      [] []  [] [3] [4] [] [3,3] [[3,4], [7]   [4,4]    [3,3,3]      [[3,4,3], [7,3]]      [4,4,3], [3,4,4], [7,4]



     1,2,3   4

     []
     [1]
     [1,1] [2]
     [1,1,1] [2,1] [3]
     [1,1,1,1] [2,1,1] [3,1] [4]

     t*
     */

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        var dp = new ArrayList<HashSet<HashMap<Integer, Integer>>>(target + 1);
        dp.add(new HashSet<>());
        for (var i = 1; i <= target; i++) {
            dp.add(new HashSet<>());
            for (var num : nums) {
                if (num == i) {
                    var m = new HashMap<Integer, Integer>();
                    m.put(num, 1);
                    dp.get(i).add(m);
                } else if (num < i) {
                    if (!dp.get(i - num).isEmpty()) {
                        for (var map : dp.get(i - num)) {
                            var currMap = new HashMap<Integer, Integer>(map);
                            currMap.put(num, currMap.getOrDefault(num, 0) + 1);
                            dp.get(i).add(currMap);
                        }
                    }
                }
            }
        }

        var result = new ArrayList<List<Integer>>();
        for (var resMap : dp.get(target)) {
            result.add(new ArrayList<>());
            for (var entry : resMap.entrySet()) {
                var num = entry.getKey();
                var repeat = entry.getValue();
                for (int i = 0; i < repeat; i++) {
                    result.get(result.size() - 1).add(num);
                    result.get(result.size() - 1).sort(Integer::compareTo);
                }
            }
        }

        return result;


    }

    public static List<List<Integer>> combinationSumRec(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        explore(nums, target, 0, new LinkedList<>(), result);
        return result;
    }

    public static void explore(int[] nums, int target, int startingIndex, LinkedList<Integer> currPath, ArrayList<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = startingIndex; i < nums.length; i++) {
            currPath.add(nums[i]);
            explore(nums, target - nums[i], i, currPath, result);
            currPath.removeLast();
        }

    }
}


