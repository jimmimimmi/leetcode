package com.jimmimimmi.java.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CycleInDirectedGraph {
    public boolean hasCycle(String[] nodes, String[][] edges) {
        var nodesNumbers = IntStream.range(0, nodes.length).boxed().collect(Collectors.toMap(i -> nodes[i], i -> i));
        HashSet<Integer>[] adjacencySet = new HashSet[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            adjacencySet[i] = new HashSet<>();
        }

        for (var edge : edges) {
            adjacencySet[nodesNumbers.get(edge[0])].add(nodesNumbers.get(edge[1]));
        }

        var blackSet = new HashSet<Integer>();
        var greySet = new HashSet<Integer>();

        var whiteSet = IntStream.range(0, nodes.length).boxed().collect(Collectors.toCollection(HashSet::new));

        for (int i = 0; i < nodes.length; i++) {
            if (whiteSet.contains(i)) {
                boolean hasCycle = dfs(i, whiteSet, blackSet, greySet, adjacencySet);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, HashSet<Integer> whiteSet, HashSet<Integer> blackSet, HashSet<Integer> greySet, HashSet<Integer>[] adjacencySet) {
        if (greySet.contains(i)) return true;
        if (blackSet.contains(i)) return false;

        whiteSet.remove(i);
        greySet.add(i);

        for (Integer child : adjacencySet[i]) {
            var hasCycle = dfs(child, whiteSet, blackSet, greySet, adjacencySet);
            if (hasCycle) return true;
        }
        greySet.remove(i);
        blackSet.add(i);


        return false;
    }
}
