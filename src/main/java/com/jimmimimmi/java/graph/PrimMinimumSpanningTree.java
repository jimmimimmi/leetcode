package com.jimmimimmi.java.graph;

import java.util.*;

public class PrimMinimumSpanningTree {
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

    public List<String[]> getMinimumSpanningTreeEdges(String[] nodes, Edge[] edges) {
        var nodeIndexes = new HashMap<String, Integer>();
        var vertexWithWeights = new VertexWithWeight[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            nodeIndexes.put(nodes[i], i);
            vertexWithWeights[i] = new VertexWithWeight(i, Integer.MAX_VALUE);
        }

        List<int[]>[] adjacentNodes = new ArrayList[nodes.length];
        for (var edge : edges) {
            var fromIndex = nodeIndexes.get(edge.from);
            var toIndex = nodeIndexes.get(edge.to);
            if (adjacentNodes[fromIndex] == null) {
                adjacentNodes[fromIndex] = new ArrayList<>();
            }
            adjacentNodes[fromIndex].add(new int[]{toIndex, edge.weight});

            if (adjacentNodes[toIndex] == null) {
                adjacentNodes[toIndex] = new ArrayList<>();
            }
            adjacentNodes[toIndex].add(new int[]{fromIndex, edge.weight});
        }

        var includedInResult = new boolean[nodes.length];
        var parents = new int[nodes.length];

        vertexWithWeights[0].weight = 0;
        includedInResult[0] = true;
        parents[0] = -1;

        var minQueue = new PriorityQueue<VertexWithWeight>();
        var c = Arrays.asList(vertexWithWeights);
        minQueue.addAll(c);

        while (!minQueue.isEmpty()) {
            var currentMinNode = minQueue.poll();
            includedInResult[currentMinNode.node] = true;

            for (var adjNode : adjacentNodes[currentMinNode.node]) {
                var adjNodeNumber = adjNode[0];
                var adjNodeWeight = adjNode[1];
                if (!includedInResult[adjNodeNumber]) {
                    if (vertexWithWeights[adjNodeNumber].weight > adjNodeWeight) {
                        minQueue.remove(vertexWithWeights[adjNodeNumber]);
                        vertexWithWeights[adjNodeNumber].weight = adjNodeWeight;
                        minQueue.add(vertexWithWeights[adjNodeNumber]);
                        parents[adjNodeNumber] = currentMinNode.node;
                    }
                }
            }
        }

        var result = new ArrayList<String[]>();

        for (int i = 1; i < nodes.length; i++) {
            var parent = nodes[parents[i]];
            var node = nodes[i];
            result.add(new String[]{parent, node});
        }

        return result;
    }
}
