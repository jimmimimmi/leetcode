package com.jimmimimmi.java.graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TarjanArticulationPoints {
    public List<String> getArticulationPoints(String[] nodes, String[][] edges) {
        var nodesToNums = IntStream.range(0, nodes.length).boxed().collect(Collectors.toMap(i -> nodes[i], i -> i));
        var parents = new Integer[nodes.length];
        var visitedTime = new Integer[nodes.length];
        var lowTime = new Integer[nodes.length];
        var timeCounter = new AtomicInteger(0);

        Set<Integer>[] adjacencyList = new Set[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            adjacencyList[i] = new HashSet<>();
        }

        for (var edge : edges) {
            var from = nodesToNums.get(edge[0]);
            var to = nodesToNums.get(edge[1]);
            adjacencyList[from].add(to);
            adjacencyList[to].add(from);
        }

        var result = new HashSet<Integer>();

        for (int i = 0; i < nodes.length; i++) {
            dfs(adjacencyList, parents, visitedTime, lowTime, timeCounter, result, i, null);
        }

        return result.stream().map(i -> nodes[i]).collect(Collectors.toList());
    }

    private void dfs(Set<Integer>[] adjacencyList, Integer[] parents, Integer[] visitedTime, Integer[] lowTime, AtomicInteger timeCounter, Set<Integer> result, int i, Integer parent) {
        if (visitedTime[i] != null) return;
        visitedTime[i] = timeCounter.incrementAndGet();
        lowTime[i] = visitedTime[i];
        parents[i] = parent;
        var childrenQuantity = 0;
        var isArticulationPoint = false;
        var childIterator = adjacencyList[i].iterator();
        while (childIterator.hasNext()) {
            var child = childIterator.next();
            if (visitedTime[child] == null) {
                childrenQuantity++;
                dfs(adjacencyList, parents, visitedTime, lowTime, timeCounter, result, child, i);

                if (visitedTime[i] <= lowTime[child]) {
                    isArticulationPoint = true;
                } else if (lowTime[i] > lowTime[child]) {
                    lowTime[i] = lowTime[child];
                }
            } else if (lowTime[i] > visitedTime[child]) {
                lowTime[i] = visitedTime[child];
            }
        }

        if (parent == null && childrenQuantity >= 2) {
            result.add(i);
        } else if (parent != null && isArticulationPoint) {
            result.add(i);
        }
    }
}
