package com.jimmimimmi.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BellmanFordSingleSourceShortestPath {
    public static class Edge {
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
    }

    public List<Edge> getShortestPath(String source, String[] nodes, Edge[] edges) {
        var nameToNumbers = new HashMap<String, Integer>();
        for (int i = 0; i < nodes.length; i++) {
            nameToNumbers.put(nodes[i], i);
        }
        var sourceNumber = nameToNumbers.get(source);
        var parents = new int[nodes.length];
        Arrays.fill(parents, -1);

        var distance = new Integer[nodes.length];
        distance[sourceNumber] = 0;

        HashMap<Integer, Integer>[] adjacencyLists = new HashMap[nodes.length];
        for (var edge : edges) {
            int from = nameToNumbers.get(edge.from);
            int to = nameToNumbers.get(edge.to);
            if (adjacencyLists[from] == null) adjacencyLists[from] = new HashMap<>();
            adjacencyLists[from].put(to, edge.weight);
        }

        for (int i = 0; i < nodes.length - 1; i++) {
            for (var edge : edges) {
                int from = nameToNumbers.get(edge.from);
                int to = nameToNumbers.get(edge.to);
                if (distance[from] != null) {
                    if (distance[to] == null || distance[to] > distance[from] + edge.weight) {
                        distance[to] = distance[from] + edge.weight;
                        parents[to] = from;
                    }
                }
            }
        }

        var result = new ArrayList<Edge>();

        for (int i = 0; i < nodes.length; i++) {
            var node = nodes[i];
            if (i == sourceNumber) result.add(new Edge(node, node, 0));
            else if (parents[i] == -1) result.add(new Edge("NA", node, Integer.MAX_VALUE));
            else result.add(new Edge(nodes[parents[i]], node, distance[i]));
        }

        return result;
    }
}
