package com.jimmimimmi.java.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DisjointSet<T> {
    public Integer countDisjointSets(HashMap<T, List<T>> adjacencyList) {
        var nodeIndexes = new HashMap<T, Integer>();

        int num = 0;
        for (T node : adjacencyList.keySet()) {
            nodeIndexes.put(node, num);
            num++;
        }
        var parents = new int[num];
        var ranks = new int[num];
        for (int i = 0; i < num; i++) {
            parents[i] = i;
        }

        for (var entry : adjacencyList.entrySet()
        ) {
            var current = nodeIndexes.get(entry.getKey());
            for (var adjacentNode : entry.getValue()
            ) {
                var currentSet = findSet(current, parents);
                var adjacentSet = findSet(nodeIndexes.get(adjacentNode), parents);
                union(currentSet, adjacentSet, parents, ranks);
            }
        }

        return (int) Arrays.stream(parents).boxed().distinct().count();
    }

    private int findSet(int node, int[] parents) {
        if (node == parents[node]) return node;

        var parent = findSet(parents[node], parents);
        parents[node] = parent;
        return parent;
    }

    private void union(int n1, int n2, int[] parents, int[] ranks) {
        var p1 = findSet(n1, parents);
        var p2 = findSet(n2, parents);

        if (p1 == p2) return;

        if (ranks[p1] >= ranks[p2]) {
            parents[p2] = p1;
            if (ranks[p1] == ranks[p2]) {
                ranks[p1]++;
            }
        } else union(n2, n1, parents, ranks);
    }
}
