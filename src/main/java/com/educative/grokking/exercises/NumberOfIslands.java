package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {
    private static String findParent(String i, String j, HashMap<String, String> parentMap) {
        var key = i + "," + j;
        if (parentMap.get(key).equals(key)) {
            return key;
        } else {
            var parentOfKey = parentMap.get(key);
            var i_j = parentOfKey.split(",");
            var par = findParent(i_j[0], i_j[1], parentMap);
            parentMap.put(key, par);
            return par;
        }
    }

    private static void union(String i1, String j1, String i2, String j2, HashMap<String, String> parentMap, HashMap<String, Integer> rank) {
        var parent1 = findParent(i1, j1, parentMap);
        var parent2 = findParent(i2, j2, parentMap);
        if (parent1.equals(parent2)) {
            return;
        }

        if (rank.get(parent1) >= rank.get(parent2)) {
            parentMap.put(parent2, parent1);
            rank.put(parent1, rank.get(parent1) + rank.get(parent2));
        } else {
            parentMap.put(parent1, parent2);
            rank.put(parent2, rank.get(parent1) + rank.get(parent2));
        }
    }

    public static int numIslands(List<List<Character>> grid) {
        if (grid == null || grid.isEmpty()) {
            return 0;
        }
        var parent = new HashMap<String, String>();
        var rank = new HashMap<String, Integer>();

        var colLength = grid.get(0).size();
        var rowLength = grid.size();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid.get(i).get(j) != '1') continue;
                parent.put(i + "," + j, i + "," + j);
                rank.put(i + "," + j, 1);
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid.get(i).get(j) != '1') {
                    continue;
                }
                if (j + 1 < colLength) {
                    if (grid.get(i).get(j + 1) == '1') {
                        union("" + i, "" + j, "" + i, "" + (j + 1), parent, rank);
                    }
                }
                if (i + 1 < rowLength) {
                    if (grid.get(i + 1).get(j) == '1') {
                        union("" + i, "" + j, "" + (i + 1), "" + j, parent, rank);
                    }
                }
            }
        }

        var parentSet = new HashSet<String>();
        var entries = new HashSet<>(parent.entrySet());
        for (var e : entries) {
            var i_j = e.getKey().split(",");
            parentSet.add(findParent(i_j[0], i_j[1], parent));
        }

        return parentSet.size();
    }

    public static int numIslands(char[][] grid) {
        var lists = new ArrayList<List<Character>>();
        for (char[] chars : grid) {
            var l = new ArrayList<Character>();
            lists.add(l);
            for (char aChar : chars) {
                l.add(aChar);
            }
        }

        return numIslands(lists);
    }
}
