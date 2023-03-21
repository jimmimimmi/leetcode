package com.jimmimimmi.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KruskalMinimumSpanningTree {

    public static class Edge implements Comparable<Edge> {
        String from;
        String to;
        int weight;

        public Edge(String from, String to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public static Edge create(String from, String to, int weight) {
            return new Edge(from, to, weight);
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public List<Edge> getMinimumSpanningTreeEdges(String[] nodes, Edge[] edges) {
        var parents = new int[nodes.length];
        var ranks = new int[nodes.length];
        var nodeToNumbers = new HashMap<String, Integer>();
        var result = new ArrayList<Edge>();

        for (int i = 0; i < nodes.length; i++) {
            nodeToNumbers.put(nodes[i], i);
            parents[i] = i;
        }

        Arrays.sort(edges);

        for (var edge : edges) {
            int from = nodeToNumbers.get(edge.from);
            int to = nodeToNumbers.get(edge.to);
            var united = union(from, to, parents, ranks);
            if (united) result.add(edge);
        }

        return result;
    }

    private int findParent(int node, int[] parents) {
        if (node == parents[node]) return node;

        int parent = findParent(parents[node], parents);
        parents[node] = parent;
        return parent;
    }

    private boolean union(int n1, int n2, int[] parents, int[] ranks) {
        int p1 = findParent(n1, parents);
        int p2 = findParent(n2, parents);

        if (p1 == p2) return false;

        if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
            ranks[p1]++;
        }
        return true;

    }
}
