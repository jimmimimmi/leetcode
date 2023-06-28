package com.educative.grokking.exercises;

import java.util.*;

/*
In this challenge, you are given a list of words written in an alien language,
where the words are sorted lexicographically by the rules of this language.
Surprisingly, the aliens also use English lowercase letters, but possibly in a different order.

Given a list of words written in the alien language,
you have to return a string of unique letters sorted in the lexicographical order of
the alien language as derived from the list of words.

If there’s no solution, that is, no valid lexicographical ordering, you can return an empty string.
 */
public class AlienDictionary {
    public static String alienOrderBfs(String[] wordsArr) {

        var words = new ArrayList<>(Arrays.asList(wordsArr));
        var graph = new HashMap<Character, HashSet<Character>>();
        var inDegree = new HashMap<Character, Integer>();
        words.forEach(word -> {
            var chars = word.toCharArray();
            for (char c : chars) {
                inDegree.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        });
        var zeroDegreeQueue = new ArrayDeque<Character>();

        for (int i = 0; i < words.size() - 1; i++) {
            var cur = words.get(i);
            var next = words.get(i + 1);
            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }

            var idx = 0;
            for (idx = 0; idx < cur.length() && idx < next.length(); idx++) {
                var from = cur.charAt(idx);
                var to = next.charAt(idx);

                if (from == to) {
                    continue;
                }
                if (!graph.get(from).contains(to)) {
                    graph.get(from).add(to);
                    inDegree.put(to, inDegree.get(to) + 1);
                }
                break;
            }
        }

        inDegree.forEach((key, value) -> {
            if (value == 0) {
                zeroDegreeQueue.addLast(key);
            }
        });

        var result = new ArrayList<Character>();
        while (!zeroDegreeQueue.isEmpty()) {
            var ready = zeroDegreeQueue.pollFirst();
            result.add(ready);
            var nexts = graph.get(ready);
            if (nexts != null) {
                nexts.forEach(n -> {
                    var nextInDegree = inDegree.get(n) - 1;
                    inDegree.put(n, nextInDegree);
                    if (nextInDegree == 0) {
                        zeroDegreeQueue.addLast(n);
                    }
                });
            }
        }

        if (result.size() != inDegree.size()) {
            return "";
        }

        var sb = new StringBuilder();
        result.forEach(sb::append);

        return sb.toString();
    }

    public static String alienOrderDfs(String[] wordsArr) {

        var words = new ArrayList<>(Arrays.asList(wordsArr));
        var graph = new HashMap<Character, HashSet<Character>>();
        words.forEach(word -> {
            var chars = word.toCharArray();
            for (char c : chars) {
                graph.put(c, new HashSet<>());
            }
        });

        for (int i = 0; i < words.size() - 1; i++) {
            var cur = words.get(i);
            var next = words.get(i + 1);
            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }

            var idx = 0;
            for (idx = 0; idx < cur.length() && idx < next.length(); idx++) {
                var from = cur.charAt(idx);
                var to = next.charAt(idx);

                if (from == to) {
                    continue;
                }
                graph.get(from).add(to);
                break;
            }
        }

        var visited = new HashMap<Character, Boolean>();
        var result = new ArrayList<Character>();

        for (Character c : graph.keySet()) {
            if (!visited.containsKey(c)) {
                var res = dfs(c, graph, visited, result);
                if (!res) {
                    return "";
                }
            }
        }


        if (result.size() != graph.size()) {
            return "";
        }
        Collections.reverse(result);

        var sb = new StringBuilder();
        result.forEach(sb::append);

        return sb.toString();
    }

    private static boolean dfs(
            Character node,
            HashMap<Character, HashSet<Character>> graph,
            HashMap<Character, Boolean> visited,
            ArrayList<Character> result) {
        visited.put(node, true);
        var children = graph.get(node);
        if (children != null) {
            for (var child : children) {
                if (visited.get(child) == null) {
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
        result.add(node);
        return true;

    }
}
