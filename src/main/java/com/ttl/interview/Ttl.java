package com.ttl.interview;

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
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Ttl {

//    private void explore(int n, int k, int current, List<List<Integer>> result, List<Integer> subResult) {
//
//        if (subResult.size() == k) {
//            result.add(new ArrayList<>(subResult));
//            return;
//        }
//
//        for (int i = current; i <= n - (k - subResult.size()) + 1 ; i++) {
//            subResult.add(i);
//            explore(n, k, i + 1, result, subResult);
//            subResult.remove(subResult.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> combine(int n, int k) {
//        var result = new ArrayList<List<Integer>>();
//        explore(n, k, 1, result, new ArrayList<Integer>());
//        return result;
//    }


    // 100, 70
    // [80, 20]
    // [35]

    public Integer getLargestPiece(String size, List<Integer> x, List<Integer> y) {
        var split = size.split(",");

        var width = Integer.parseInt(split[0]);
        var height = Integer.parseInt(split[1]);

        var xArray = new ArrayList<Integer>();
        xArray.add(0);
        xArray.addAll(x);
        xArray.add(width); //0 , 20, 80 , 100
        xArray.sort(Integer::compareTo);

        var yArray = new ArrayList<Integer>();
        yArray.add(0);
        yArray.addAll(y);
        yArray.add(height); // 0, 35, 70
        yArray.sort(Integer::compareTo);

        Integer areaMax = 0;

        for (int i = 1; i < xArray.size(); i++) {
            for (int j = 1; j < yArray.size(); j++) {
                var deltaY = yArray.get(j) - yArray.get(j - 1);
                var deltax = xArray.get(i) - xArray.get(i - 1);

                var area = deltaY * deltax;
                if (area > areaMax) {
                    areaMax = area;
                }
            }
        }
        return areaMax;

    }


    public String findWord(List<String> precedences) {
        var forward = new HashMap<String, String>();
        var backward = new HashMap<String, String>();
        precedences.forEach(s -> {
            var split = s.split(">");
            forward.put(split[0], split[1]);
            backward.put(split[1], split[0]);
        });


        AtomicReference<String> beginning = new AtomicReference<>("");
        forward.entrySet().forEach(e -> {
            if (!backward.containsKey(e.getKey())) {
                beginning.set(e.getKey());
            }
        });

        String current = beginning.get();
        String result = current;
        boolean finished = false;
        while (!finished) {
            if (forward.containsKey(current)) {
                current = forward.get(current);
                result += current;
            } else {
                finished = true;
            }
        }

        return result;
    }
}
