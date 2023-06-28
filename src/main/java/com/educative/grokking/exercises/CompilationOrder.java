package com.educative.grokking.exercises;

import java.util.*;

/*
There are a total of n classes labeled with the English alphabet
Some classes are dependent on other classes for compilation. For example, if class
B extends class A, then B has a dependency on A.
Therefore, A must be compiled before B.

Given a list of the dependency pairs, find the order in which the classes should be compiled.
 */
public class CompilationOrder {
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {

        var graph = new HashMap<Character, List<Character>>();
        dependencies.forEach(dep -> {
            var to = dep.get(0);
            var from = dep.get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
        });

        var visited = new HashSet<Character>();
        var result = new ArrayList<Character>();
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            Character node = entry.getKey();
            if (!visited.contains(node)) {
                var dfs = dfs(node, visited, new HashSet<>(), graph, result);
                if (!dfs) {
                    return new ArrayList<>();
                }
            }
        }

        Collections.reverse(result);
        return result;
    }

    private static boolean dfs(
            Character node,
            HashSet<Character> visited,
            HashSet<Character> visitedOnPath,
            HashMap<Character,
                    List<Character>> graph, ArrayList<Character> result) {
        boolean res = true;
        visited.add(node);
        visitedOnPath.add(node);
        var nexts = graph.get(node);
        if (nexts != null) {
            for (Character next : nexts) {
                if (visitedOnPath.contains(next)) {
                    res = false;
                    break;
                }
                if (!visited.contains(next)) {
                    if (!dfs(next, visited, visitedOnPath, graph, result)) {
                        res = false;
                        break;
                    }
                }
            }
        }
        if (res) {
            result.add(node);
            visitedOnPath.remove(node);
        }
        return res;
    }
}
