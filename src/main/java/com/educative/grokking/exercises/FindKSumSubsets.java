package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a set of n positive integers,
find all the possible subsets of integers that sum up to a number k.
 */
public class FindKSumSubsets {
    public static List<List<Integer>> getKSumSubsets2(List<Integer> setOfIntegers, int targetSum) {
        // Write your code here
        var result = new HashSet<HashSet<Integer>>();
        rec(new ArrayList<>(setOfIntegers), targetSum, 0, new ArrayList<>(), 0, result);
        return result.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    private static void rec(ArrayList<Integer> setOfIntegers, int targetSum, int curIndex, ArrayList<Integer> output, int outputSum, HashSet<HashSet<Integer>> result) {
        if (outputSum == targetSum) {
            var outputCopy = new HashSet<>(output);
            result.add(outputCopy);
            return;
        }
        if (outputSum > targetSum) {
            return;
        }

        if (curIndex == setOfIntegers.size()) {
            return;
        }

        for (int i = curIndex; i < setOfIntegers.size(); i++) {
            var iVal = setOfIntegers.get(i);
            var curIndexVal = setOfIntegers.get(curIndex);
            iVal = iVal + curIndexVal;
            curIndexVal = iVal - curIndexVal;
            iVal = iVal - curIndexVal;
            setOfIntegers.set(i, iVal);
            setOfIntegers.set(curIndex, curIndexVal);

            output.add(curIndexVal);
            rec(setOfIntegers, targetSum, curIndex + 1, output, outputSum + curIndexVal, result);
            output.remove(output.size() - 1);

            setOfIntegers.set(curIndex, iVal);
            setOfIntegers.set(i, curIndexVal);
        }
    }

    static int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    static List<HashSet<Integer>> getKSumSubsets(List<Integer> setOfIntegers, Integer targetSum) {
        List<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();
        int subsetsCount = (int) (Math.pow((double) 2, (double) setOfIntegers.size()));
        for (int i = 0; i < subsetsCount; ++i) {
            int sum = 0;
            HashSet<Integer> subset = new HashSet<Integer>();
            for (int j = 0; j < setOfIntegers.size(); j++) {
                // if the jth number should be included in this subset
                if (getBit(i, j) == 1) {
                    // add it to the sum
                    sum += setOfIntegers.get(j);

                    // and check it against the target
                    if (sum > targetSum) {
                        // reject the jth number if the sum exceeds the target
                        break;
                    }
                    subset.add(setOfIntegers.get(j));
                }
            }
            if (sum == targetSum) {
                // if the sum matches the target, save the candidate subset as a valid solution
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
