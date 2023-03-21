package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class PrimMinimumSpanningTreeTest extends TestCase {

    public void testGetMinimumSpanningTreeEdges() {
        var minSpanningTree = new PrimMinimumSpanningTree().getMinimumSpanningTreeEdges(
                new String[]{"A", "B", "C", "D", "E", "F"},
                new PrimMinimumSpanningTree.Edge[]{
                        PrimMinimumSpanningTree.Edge.create("A", "B", 3),
                        PrimMinimumSpanningTree.Edge.create("A", "D", 1),
                        PrimMinimumSpanningTree.Edge.create("B", "C", 1),
                        PrimMinimumSpanningTree.Edge.create("B", "D", 3),
                        PrimMinimumSpanningTree.Edge.create("C", "D", 1),
                        PrimMinimumSpanningTree.Edge.create("C", "F", 4),
                        PrimMinimumSpanningTree.Edge.create("C", "E", 0),
                        PrimMinimumSpanningTree.Edge.create("D", "E", 6),
                        PrimMinimumSpanningTree.Edge.create("E", "F", 2)
                }
        );

        System.out.println(minSpanningTree.stream().map(m -> "(" + m[0] + " -> " + m[1] + ")").collect(Collectors.joining(";")));
    }
}