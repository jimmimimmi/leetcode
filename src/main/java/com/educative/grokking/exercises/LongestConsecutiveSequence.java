package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    private static int findParent(int num, Map<Integer, Integer> parents) {
        parents.putIfAbsent(num, num);
        if (parents.get(num).equals(num)) {
            return num;
        } else {
            var res = findParent(parents.get(num), parents);
            parents.put(num, res);
            return res;
        }
    }

    private static void union(int a, int b, Map<Integer, Integer> parents, Map<Integer, Integer> ranks, int[] max) {
        var parA = findParent(a, parents);
        var parB = findParent(b, parents);
        ranks.putIfAbsent(parA, 1);
        ranks.putIfAbsent(parB, 1);

        if (parA == parB) {
            return;
        }

        var newRank = ranks.get(parA) + ranks.get(parB);
        if (ranks.get(parA) >= ranks.get(parB)) {
            ranks.put(parA, newRank);
            parents.put(parB, parA);
        } else {
            ranks.put(parB, newRank);
            parents.put(parA, parB);
        }

        if (max[0] < newRank) {
            max[0] = newRank;
        }

    }

    public static int longestConsecutiveSequence(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        var parents = new HashMap<Integer, Integer>();
        var ranks = new HashMap<Integer, Integer>();
        var numSet = new HashSet<Integer>();
        var maxRank = new int[]{1};
        for (var n : nums) {
            numSet.add(n);
            if (numSet.contains(n - 1)) {
                union(n, n - 1, parents, ranks, maxRank);
            }
            if (numSet.contains(n + 1)) {
                union(n, n + 1, parents, ranks, maxRank);
            }
        }

        return maxRank[0];
    }
}
