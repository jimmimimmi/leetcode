package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given a set of integers, find all possible subsets within the set.
 */
public class Subsets {

    public static List<HashSet<Integer>> findAllSubsets(List<Integer> v) {
        // Write your code here

        // Your code will replace the below return placeholder

        List<HashSet<Integer>> setsList = new ArrayList<HashSet<Integer>>();

        var totalSubsetsCount = Math.pow(2, v.size());
        for (int i = 0; i < totalSubsetsCount; i++) {
            var subset = new HashSet<Integer>();
            for (int j = 0; j < v.size(); j++) {
                var bitMask = 1 << j;
                var bitMaskApplied = bitMask & i;
                if (bitMaskApplied != 0){
                    subset.add(v.get(j));
                }
            }
            setsList.add(subset);
        }
        return setsList;
    }
}
