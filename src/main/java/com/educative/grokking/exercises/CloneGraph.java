package com.educative.grokking.exercises;


import java.util.*;

// https://leetcode.com/problems/clone-graph/description/
class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }
}

public class CloneGraph {

    public static Node clone(Node root) {

        if (root == null) return null;

        var rootClone = new Node(root.data);

        var queue1 = new ArrayDeque<Node>();
        var queue2 = new ArrayDeque<Node>();
        var exlored = new HashSet<Node>();
        queue1.offer(root);
        queue2.offer(rootClone);
        var clones = new HashMap<Node, Node>();
        clones.put(root, rootClone);

        while (!queue1.isEmpty()) {
            var size = queue1.size();
            for (int i = 0; i < size; i++) {
                var orig = queue1.poll();
                var clone = queue2.poll();
                if (exlored.contains(orig)) {
                    continue;
                }
                exlored.add(orig);
                for (var origNeighbour : orig.neighbors) {
                    if (!clones.containsKey(origNeighbour)) {
                        clones.put(origNeighbour, new Node(origNeighbour.data));
                    }
                    var cloneNeighb = clones.get(origNeighbour);
                    clone.neighbors.add(cloneNeighb);
                    if (!exlored.contains(origNeighbour)) {
                        queue1.add(origNeighbour);
                        queue2.add(cloneNeighb);
                    }
                }

            }
        }

        return rootClone;
    }

    public static Node cloneRecursive(Node node, Map<Node, Node> nodes) {
        if (node == null) {
            return null;
        }
        var clone = nodes.get(node);
        if (clone == null) {
            clone = new Node(node.data);
            nodes.put(node, clone);
        }
        for (var neighb : node.neighbors) {
            var neighbClone = nodes.get(neighb);
            if (neighbClone == null) {
                neighbClone = cloneRecursive(neighb, nodes);
            }
            clone.neighbors.add(neighbClone);
        }
        return clone;
    }
}
