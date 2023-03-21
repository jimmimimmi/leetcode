package com.jimmimimmi.java.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FloydWarshallAllPairsShortesPath {
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

    public List<String> getShortestPath(String[] nodes, Edge[] edges, String from, String to) {

        var nodesToNumbers = new HashMap<String, Integer>();
        for (int i = 0; i < nodes.length; i++) {
            nodesToNumbers.put(nodes[i], i);
        }

        var distance = new Integer[nodes.length][nodes.length];
        var path = new Integer[nodes.length][nodes.length];

        for (var edge : edges) {
            var i = nodesToNumbers.get(edge.from);
            var j = nodesToNumbers.get(edge.to);
            distance[i][j] = edge.weight;
            path[i][j] = i;
        }
        for (int k = 0; k < nodes.length; k++) {
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes.length; j++) {
                    if (distance[i][k] == null || distance[k][j] == null) continue;

                    if (distance[i][j] == null || distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        //check for negative cycle
        for (int i = 0; i < nodes.length; i++) {
            if (distance[i][i] != null && distance[i][i] < 0) {
                throw new RuntimeException();
            }
        }


        var stack = new ArrayDeque<Integer>();
        var fromNum = nodesToNumbers.get(from);
        var toNum = nodesToNumbers.get(to);
        stack.addLast(toNum);
        Boolean found = null;
        while (true) {
            toNum = path[fromNum][toNum];
            if (toNum == null) {
                found = false;
                break;
            }
            stack.addLast(toNum);
            if (toNum.equals(fromNum)) {
                found = true;
                break;
            }
        }

        var result = new ArrayList<String>();
        if (found) {
            while (!stack.isEmpty()) {
                result.add(nodes[stack.removeLast()]);
            }
        }

        return result;
    }

}
