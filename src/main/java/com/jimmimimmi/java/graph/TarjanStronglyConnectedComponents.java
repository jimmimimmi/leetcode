package com.jimmimimmi.java.graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TarjanStronglyConnectedComponents {
    public List<List<String>> getScc(String[] nodes, String[][] edges) {
        var nodeNumbers = IntStream.range(0, nodes.length).boxed().collect(Collectors.toMap(i -> nodes[i], i -> i));
        HashSet<Integer>[] adjacencyList = new HashSet[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            adjacencyList[i] = new HashSet<>();
        }

        for (var edge : edges) {
            var from = nodeNumbers.get(edge[0]);
            var to = nodeNumbers.get(edge[1]);
            adjacencyList[from].add(to);
        }

        var visitedTime = new Integer[nodes.length];
        var lowTime = new Integer[nodes.length];
        var onStack = new boolean[nodes.length];
        var dfsStack = new ArrayDeque<Integer>();
        var result = new ArrayList<List<Integer>>();
        var timeCounter = new AtomicInteger();

        for (int i = 0; i < nodes.length; i++) {
            if (visitedTime[i] != null) continue;
            dfs(i, timeCounter, adjacencyList, visitedTime, lowTime, onStack, dfsStack, result);
        }
        return result.stream().map(l -> l.stream().map(i -> nodes[i]).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private void dfs(
            int i,
            AtomicInteger counter,
            HashSet<Integer>[] adjacencyList,
            Integer[] visitedTime,
            Integer[] lowTime,
            boolean[] onStack,
            ArrayDeque<Integer> dfsStack,
            ArrayList<List<Integer>> result) {
        visitedTime[i] = counter.getAndIncrement();
        lowTime[i] = visitedTime[i];
        onStack[i] = true;
        dfsStack.addLast(i);
        var childIterator = adjacencyList[i].iterator();

        while (childIterator.hasNext()) {
            var child = childIterator.next();
            if (visitedTime[child] == null) {
                dfs(child, counter, adjacencyList, visitedTime, lowTime, onStack, dfsStack, result);
                lowTime[i] = Math.min(lowTime[i], lowTime[child]);
            } else if (onStack[child]) {
                lowTime[i] = Math.min(lowTime[i], visitedTime[child]);
            }
        }

        if (visitedTime[i].equals(lowTime[i])) {
            var stronglyConnectedComponent = new ArrayList<Integer>();
            while (true) {
                var pop = dfsStack.removeLast();
                onStack[pop] = false;
                stronglyConnectedComponent.add(pop);
                if (pop == i) break;
            }
            result.add(stronglyConnectedComponent);
        }
    }
}
