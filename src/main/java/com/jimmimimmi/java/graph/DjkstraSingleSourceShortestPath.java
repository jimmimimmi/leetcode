package com.jimmimimmi.java.graph;

import java.util.*;

public class DjkstraSingleSourceShortestPath {
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

    public static class VertexWithWeight implements Comparable<VertexWithWeight> {

        int node;
        int weight;

        public VertexWithWeight(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public static VertexWithWeight create(int node, int weight) {
            return new VertexWithWeight(node, weight);
        }

        @Override
        public int compareTo(VertexWithWeight o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VertexWithWeight that = (VertexWithWeight) o;

            if (node != that.node) return false;
            return weight == that.weight;
        }

        @Override
        public int hashCode() {
            int result = node;
            result = 31 * result + weight;
            return result;
        }
    }

    public List<Edge> getMinimumSpanningTreeEdges(String source, String[] nodes, Edge[] edges) {
        var nameToNumbers = new HashMap<String, Integer>();
        for (int i = 0; i < nodes.length; i++) {
            nameToNumbers.put(nodes[i], i);
        }
        var sourceNumber = nameToNumbers.get(source);
        var parents = new int[nodes.length];
        Arrays.fill(parents, -1);

        var nodesWithWeight = new VertexWithWeight[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            nodesWithWeight[i] = new VertexWithWeight(i, Integer.MAX_VALUE);
        }

        parents[sourceNumber] = sourceNumber;
        nodesWithWeight[sourceNumber].weight = 0;

        var queue = new PriorityQueue<VertexWithWeight>();
        queue.addAll(Arrays.asList(nodesWithWeight));
        var finished = new boolean[nodes.length];

        Map<Integer, Integer>[] adjacencyLists = new HashMap[nodes.length];
        for (var edge : edges) {
            var from = nameToNumbers.get(edge.from);
            var to = nameToNumbers.get(edge.to);
            if (adjacencyLists[from] == null) {
                adjacencyLists[from] = new HashMap<>();
            }
            if (adjacencyLists[to] == null) {
                adjacencyLists[to] = new HashMap<>();
            }
            adjacencyLists[from].put(to, edge.weight);
            adjacencyLists[to].put(from, edge.weight);
        }

        while (!queue.isEmpty()) {
            var current = queue.poll();
            finished[current.node] = true;

            var children = adjacencyLists[current.node];
            for (var child : children.entrySet()) {
                var childNum = child.getKey();
                if (!finished[childNum] && nodesWithWeight[childNum].weight > current.weight + child.getValue()) {
                    queue.remove(nodesWithWeight[childNum]);
                    nodesWithWeight[childNum].weight = current.weight + child.getValue();
                    queue.add(nodesWithWeight[childNum]);
                    parents[childNum] = current.node;
                }
            }
        }

        var result = new ArrayList<Edge>();

        for (int i = 0; i < nodes.length; i++) {
            if (i == sourceNumber) continue;
            var parent = nodes[parents[i]];
            var node = nodes[i];
            var weight = adjacencyLists[parents[i]].get(i);

            result.add(new Edge(parent, node, weight));
        }

        return result;
    }
}
