package com.jimmimimmi.java.graph;

import java.util.*;

public class TopologicalSort<T> {
    public List<T> sort(HashMap<T, List<T>> adjacencyList) {
        var visited = new HashSet<T>();
        var stack = new ArrayDeque<T>();

        for (var vertex : adjacencyList.keySet()) {
            dfs(vertex, adjacencyList, visited, stack);
        }

        var result = new ArrayList<T>();
        while (!stack.isEmpty()) {
            var pop = stack.removeLast();
            result.add(pop);
        }
        return result;
    }

    private void dfs(T current, HashMap<T, List<T>> adjacencyList, Set<T> visited, Deque<T> stack) {
        if (visited.contains(current)) return;
        visited.add(current);
        var children = adjacencyList.get(current);
        if (children != null) {
            for (var child : children) {
                dfs(child, adjacencyList, visited, stack);
            }
        }
        stack.addLast(current);
    }
}
