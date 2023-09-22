package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/editorial/
public class NetworkDelay {

    public static int networkDelayTime(int[][] times, int n, int k) {

        var graph = new HashMap<Integer, ArrayList<int[]>>();
        for (int[] edge : times) {
            var from = edge[0];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(edge);
        }


        if (!graph.containsKey(k)) {
            return -1;
        }

        var distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[k] = 0;
//        bfs(k, graph, distances);
//        dfs(k, graph, distances);
        Arrays.fill(distances, Integer.MAX_VALUE);
        dijkstra(k, graph, distances);


        int result = -1;
        for (var i = 1; i < distances.length; i++) {
            if (distances[i] == -1) {
                return -1;
            }
            if (distances[i] > result) result = distances[i];
        }

        return result;
    }

    private static void dfs(int node, HashMap<Integer, ArrayList<int[]>> graph, int[] distances) {
        var edges = graph.get(node);
        if (edges != null) {
            for (var edge : edges) {
                var to = edge[1];
                var dist = edge[2];
                if (distances[to] == -1 || distances[to] > distances[node] + dist) {
                    distances[to] = distances[node] + dist;
                    dfs(to, graph, distances);
                }
            }
        }
    }


    private static void bfs(int k, HashMap<Integer, ArrayList<int[]>> graph, int[] distances) {
        var edges = graph.get(k);
        if (edges == null) return;
        var queue = new ArrayDeque<>(edges);

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var edge = queue.poll();
                var from = edge[0];
                var to = edge[1];
                var dist = edge[2];
                if (distances[to] == -1 || distances[to] > distances[from] + dist) {
                    distances[to] = distances[from] + dist;
                    var next = graph.get(to);
                    if (next != null) queue.addAll(next);
                }
            }
        }
    }

    private static void dijkstra(int k, HashMap<Integer, ArrayList<int[]>> graph, int[] distances) {
        var edges = graph.get(k);
        if (edges == null) return;
        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        queue.add(new int[]{0, k});

        while (!queue.isEmpty()) {
            var edge = queue.poll();
            var minDist = edge[0];
            var to = edge[1];
            if (minDist < distances[to]) {
                distances[to] = minDist;
                var next = graph.get(to);
                if (next != null) {
                    next.forEach(n -> {
                        var toNext = n[1];
                        var dist = n[2];
                        queue.add(new int[]{minDist + dist, toNext});
                    });
                }
            }
        }
    }
}
