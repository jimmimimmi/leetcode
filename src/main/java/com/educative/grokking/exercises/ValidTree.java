package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/graph-valid-tree/
public class ValidTree {
    public static boolean validTree(int n, int[][] edges) {

        if (edges == null || edges.length == 0) {
            return n == 0 || n == 1;
        }
        var graph = new HashMap<Integer, List<Integer>>();
        for (var edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        var visited = new HashSet<Integer>();
        var result = explore(edges[0][0], null, graph, visited);
        if (result && visited.size() == n) {
            return true;
        }

        return false;
    }

    private static boolean explore(int node, Integer parent, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        var neighbours = graph.get(node);
        for (var n : neighbours) {
            if (!Objects.equals(n, parent)) {
                var result = explore(n, node, graph, visited);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }
}
