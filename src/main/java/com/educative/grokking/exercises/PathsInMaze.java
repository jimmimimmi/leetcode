package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/paths-in-maze-that-lead-to-same-room/description/
public class PathsInMaze {
    public static int numberOfPaths(int n, int[][] corridors) {

        var graph = new HashMap<Integer, HashSet<Integer>>();
        int result = 0;
        for (int[] corridor : corridors) {
            var from = corridor[0];
            var to = corridor[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new HashSet<>());
            }

            if (!graph.containsKey(to)) {
                graph.put(to, new HashSet<>());
            }

            graph.get(from).add(to);
            graph.get(to).add(from);

            var aNeighhours = graph.get(from);
            var bNeighhours = graph.get(to);

            for (var a : aNeighhours) {
                if (bNeighhours.contains(a)) {
                    result++;
                }
            }
        }

        return result;
    }
}
