package com.educative.grokking.exercises;

import java.util.HashMap;

// https://leetcode.com/problems/redundant-connection/description/
public class RedundantConnection {

    private static int findParent(int node, HashMap<Integer, Integer> parents) {
        if (parents.get(node) == node) {
            return node;
        } else {
            var parent = findParent(parents.get(node), parents);
            parents.put(node, parent);
            return parent;
        }
    }

    public static int[] redundantConnection(int[][] edges) {
        var parent = new HashMap<Integer, Integer>();
        var rank = new HashMap<Integer, Integer>();


        for (var edge : edges) {
            var from = edge[0];
            var to = edge[1];
            parent.put(from, from);
            parent.put(to, to);
            rank.put(from, 1);
            rank.put(to, 1);
        }

        int[] res = new int[]{};
        for (var edge : edges) {
            var a = edge[0];
            var b = edge[1];

            var parentA = findParent(a, parent);
            var parentB = findParent(b, parent);

            if (parentA == parentB) {
                res = edge;
            } else {
                var aRank = rank.get(parentA);
                var bRank = rank.get(parentB);
                if (aRank.equals(bRank)) {
                    rank.put(parentA, aRank + bRank);
                    parent.put(parentB, parentA);
                } else if (bRank < aRank) {
                    rank.put(parentA, aRank + bRank);
                    parent.put(parentB, parentA);
                } else {
                    rank.put(parentB, aRank + bRank);
                    parent.put(parentA, parentB);
                }
            }
        }


        return res;
    }
}
