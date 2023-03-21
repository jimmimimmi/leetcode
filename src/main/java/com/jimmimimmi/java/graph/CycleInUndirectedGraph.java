package com.jimmimimmi.java.graph;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CycleInUndirectedGraph {
    public boolean hasCycle(String[] nodes, String[][] edges) {
        var nodesNumbers = IntStream.range(0, nodes.length).boxed().collect(Collectors.toMap(i -> nodes[i], i -> i));
        HashSet<Integer>[] adjacencySet = new HashSet[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            adjacencySet[i] = new HashSet<>();
        }

        for (var edge : edges) {
            adjacencySet[nodesNumbers.get(edge[0])].add(nodesNumbers.get(edge[1]));
            adjacencySet[nodesNumbers.get(edge[1])].add(nodesNumbers.get(edge[0]));
        }

        var parents = new int[nodes.length];
        var rank = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            parents[i] = i;
        }

        for (var edge : edges) {
            var node1 = nodesNumbers.get(edge[0]);
            var node2 = nodesNumbers.get(edge[1]);

            var alreadyInUnion = union(node1, node2, parents, rank);
            if (alreadyInUnion) return true;
        }

        return false;
    }

    private int find(int node, int[] parents) {
        if (node == parents[node]) return node;

        var parent = find(parents[node], parents);
        parents[node] = parent;
        return parent;
    }

    private boolean union(int node1, int node2, int[] parents, int[] ranks) {
        var parent1 = find(node1, parents);
        var parent2 = find(node2, parents);

        if (parent1 == parent2) return true;

        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
        } else if (ranks[parent1] < ranks[parent2]) {
            parents[parent1] = parent2;
        } else {
            parents[parent2] = parent1;
            ranks[parent1]++;
        }
        return false;
    }
}
