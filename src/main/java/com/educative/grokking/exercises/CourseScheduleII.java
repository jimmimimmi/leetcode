package com.educative.grokking.exercises;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/description/
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {
    public static List<Integer> findOrder(int n, int[][] prerequisites) {

        var graph = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < n; i++) {
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
                    return new ArrayList<>();
                }
            }
        }

        var resArr = new int[result.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = result.pollFirst();
        }
        return new ArrayList<>(result);
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
