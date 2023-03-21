package com.jimmimimmi.java.graph;

import java.util.*;
import java.util.stream.Collectors;

public class KosarajusStronglyConnectedComponents {
    public List<List<String>> getScc(String[] nodes, String[][] edges) {
        var nodeNumbers = new HashMap<String, Integer>();
        Set<Integer>[] adjacencyList = new HashSet[nodes.length];
        Set<Integer>[] reversedAdjacencyList = new HashSet[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            nodeNumbers.put(nodes[i], i);
            adjacencyList[i] = new HashSet<>();
            reversedAdjacencyList[i] = new HashSet<>();
        }

        for (var edge : edges) {
            var from = edge[0];
            var to = edge[1];

            var fromNode = nodeNumbers.get(from);
            var toNode = nodeNumbers.get(to);

            adjacencyList[fromNode].add(toNode);
            reversedAdjacencyList[toNode].add(fromNode);
        }

        var stackByFinishDfsTime = new ArrayDeque<Integer>();
        var visited = new boolean[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            dfs(i, adjacencyList, visited, stackByFinishDfsTime);
        }

        Arrays.fill(visited, false);
        var result = new ArrayList<List<String>>();

        while (!stackByFinishDfsTime.isEmpty()) {
            var node = stackByFinishDfsTime.removeLast();
            if (visited[node]) continue;
            var subresult = new ArrayDeque<Integer>();
            dfs(node, reversedAdjacencyList, visited, subresult);
            result.add(subresult.stream().map(i -> nodes[i]).collect(Collectors.toList()));
        }
        return result;
    }


    private void dfs(int node, Set<Integer>[] adjacencyList, boolean[] visited, ArrayDeque<Integer> stack) {
        if (visited[node]) return;
        visited[node] = true;
        for (var child : adjacencyList[node]) {
            dfs(child, adjacencyList, visited, stack);
        }
        stack.addLast(node);
    }
}
