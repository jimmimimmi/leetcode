package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
public class MostStonesRemovedwithSameRoworColumn {

    private static String findParent(String stone, HashMap<String, String> parents) {
        var currParent = parents.get(stone);
        if (stone.equals(currParent)) {
            return stone;
        } else {
            var parent = findParent(currParent, parents);
            parents.put(stone, parent);
            return parent;
        }
    }

    private static void union(String s1, String s2, HashMap<String, String> parents, HashMap<String, Integer> ranks) {

        var paren1 = findParent(s1, parents);
        var paren2 = findParent(s2, parents);
        if (paren1.equals(paren2)){
            return;
        }

        var rank1 = ranks.get(paren1);
        var rank2 = ranks.get(paren2);


        if (rank1 >= rank2) {
            parents.put(paren2, paren1);
            ranks.put(paren1, rank1 + rank2);
        } else {
            parents.put(paren1, paren2);
            ranks.put(paren2, rank1 + rank2);
        }
    }

    public static int removeStones(int[][] stones) {

        var parents = new HashMap<String, String>();
        var ranks = new HashMap<String, Integer>();

        var rows = new HashMap<Integer, List<String>>();
        var cols = new HashMap<Integer, List<String>>();

        for (var coord : stones) {
            var row = coord[0];
            var col = coord[1];
            var key = row + "," + col;
            parents.put(key, key);
            ranks.put(key, 1);
            rows.computeIfAbsent(row, integer -> new ArrayList<>()).add(key);
            cols.computeIfAbsent(col, integer -> new ArrayList<>()).add(key);
        }

        for (var row : rows.entrySet()) {
            var stonesStr = row.getValue();
            for (int i = 0; i < stonesStr.size(); i++) {
                if (i + 1 < stonesStr.size()) {
                    var stone1 = stonesStr.get(i);
                    var stone2 = stonesStr.get(i + 1);
                    union(stone1, stone2, parents, ranks);
                }
            }
        }

        for (var col : cols.entrySet()) {
            var stonesStr = col.getValue();
            for (int i = 0; i < stonesStr.size(); i++) {
                if (i + 1 < stonesStr.size()) {
                    var stone1 = stonesStr.get(i);
                    var stone2 = stonesStr.get(i + 1);
                    union(stone1, stone2, parents, ranks);
                }
            }
        }

        for (var p : parents.entrySet()) {
            findParent(p.getKey(), parents);
        }

        var res = 0;
        for (var p : parents.entrySet()) {
            if (p.getKey().equals(p.getValue())) {
                res += (ranks.get(p.getKey()) - 1);
            }
        }

        return res;
    }
}
