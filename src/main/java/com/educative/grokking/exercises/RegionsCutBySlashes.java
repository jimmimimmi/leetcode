package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/regions-cut-by-slashes/description/
public class RegionsCutBySlashes {
    private static String findParent(String s, HashMap<String, String> parents) {
        parents.putIfAbsent(s, s);

        if (!parents.get(s).equals(s)) {
            parents.put(s, findParent(parents.get(s), parents));
        }
        return parents.get(s);
    }

    private static void union(String a, String b, HashMap<String, String> parents, HashMap<String, Integer> ranks) {
        var parA = findParent(a, parents);
        var parB = findParent(b, parents);
        if (parA.equals(parB)) {
            return;
        }

        ranks.putIfAbsent(parA, 1);
        ranks.putIfAbsent(parB, 1);

        var newRank = ranks.get(parA) + ranks.get(parB);
        if (ranks.get(parA) >= ranks.get(parB)) {
            parents.put(parB, parA);
            ranks.put(parA, newRank);
        } else {
            parents.put(parA, parB);
            ranks.put(parB, newRank);
        }
    }


    public int regionsBySlashes(String[] grid) {
        if (grid.length == 0) {
            return 0;
        }
        var columns = grid[0].length();

        var parents = new HashMap<String, String>();
        var ranks = new HashMap<String, Integer>();

        for (int rowNum = 0; rowNum < grid.length; rowNum++) {
            var word = grid[rowNum];
            for (int colNum = 0; colNum < columns; colNum++) {
                var num = rowNum * columns + colNum;
                var c = word.charAt(colNum);
                var top = num + ",a";
                var right = num + ",b";
                var bottom = num + ",c";
                var left = num + ",d";
                if (c == ' ') {
                    union(top, right, parents, ranks);
                    union(right, bottom, parents, ranks);
                    union(bottom, left, parents, ranks);
                    union(left, top, parents, ranks);
                } else if (c == '/') {
                    union(right, bottom, parents, ranks);
                    union(top, left, parents, ranks);
                } else {
                    union(right, top, parents, ranks);
                    union(bottom, left, parents, ranks);
                }

                if (colNum + 1 < word.length()) {
                    var nexLeft = (num + 1) + ",d";
                    union(right, nexLeft, parents, ranks);
                }
                if (rowNum + 1 < columns) {
                    var nexTop = (num + columns) + ",a";
                    union(bottom, nexTop, parents, ranks);
                }
            }
        }

        var entries = new HashSet<>(parents.entrySet());
        for (var e : entries) {
            findParent(e.getKey(), parents);
        }

        var res = 0;
        for (var e : parents.entrySet()) {
            if (e.getKey().equals(e.getValue())) {
                res++;
            }
        }
        return res;
    }
}
