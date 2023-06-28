package com.educative.grokking.exercises;

import java.util.*;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            var to = edge[0];
            var from = edge[1];

            graph.get(from).add(to);
        }

        var visited = new HashMap<Integer, Boolean>();
        var result = new ArrayDeque<Integer>();

        for (var entry : graph.entrySet()) {
            if (!visited.containsKey(entry.getKey())) {
                var res = dfs(entry.getKey(), graph, visited, result);
                if (!res) {
                    return false;
                }
            }
        }

        return true;
    }



    private static boolean dfs(Integer node, HashMap<Integer, HashSet<Integer>> graph, HashMap<Integer, Boolean> visited, ArrayDeque<Integer> result) {
        visited.put(node, true);

        var children = graph.get(node);
        if (children != null) {
            for (var child : children) {
                if (!visited.containsKey(child)) {
                    var res = dfs(child, graph, visited, result);
                    if (!res) {
                        return false;
                    }
                } else if (visited.get(child)) {
                    return false;
                }
            }
        }

        visited.put(node, false);
        result.addFirst(node);
        return true;
    }

}
