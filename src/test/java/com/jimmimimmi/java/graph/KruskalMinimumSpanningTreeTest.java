package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.List;
import java.util.stream.Collectors;

public class KruskalMinimumSpanningTreeTest extends TestCase {

    public void testGetMinimumSpanningTreeEdges() {
        var kruskal = new KruskalMinimumSpanningTree().getMinimumSpanningTreeEdges(
                new String[]{"A", "B", "C", "D", "E", "F"},
                new KruskalMinimumSpanningTree.Edge[]{
                        KruskalMinimumSpanningTree.Edge.create("A", "B", 3),
                        KruskalMinimumSpanningTree.Edge.create("A", "D", 1),
                        KruskalMinimumSpanningTree.Edge.create("B", "C", 1),
                        KruskalMinimumSpanningTree.Edge.create("B", "D", 3),
                        KruskalMinimumSpanningTree.Edge.create("C", "D", 1),
                        KruskalMinimumSpanningTree.Edge.create("C", "F", 4),
                        KruskalMinimumSpanningTree.Edge.create("C", "E", 5),
                        KruskalMinimumSpanningTree.Edge.create("D", "E", 6),
                        KruskalMinimumSpanningTree.Edge.create("E", "F", 2)
                }
        );

        System.out.println(kruskal.stream().map(m -> "(" + m.from + " -> " + m.to + ")").collect(Collectors.joining(";")));

        var prim = new PrimMinimumSpanningTree().getMinimumSpanningTreeEdges(
                new String[]{"A", "B", "C", "D", "E", "F"},
                new PrimMinimumSpanningTree.Edge[]{
                        PrimMinimumSpanningTree.Edge.create("A", "B", 3),
                        PrimMinimumSpanningTree.Edge.create("A", "D", 1),
                        PrimMinimumSpanningTree.Edge.create("B", "C", 1),
                        PrimMinimumSpanningTree.Edge.create("B", "D", 3),
                        PrimMinimumSpanningTree.Edge.create("C", "D", 1),
                        PrimMinimumSpanningTree.Edge.create("C", "F", 4),
                        PrimMinimumSpanningTree.Edge.create("C", "E", 5),
                        PrimMinimumSpanningTree.Edge.create("D", "E", 6),
                        PrimMinimumSpanningTree.Edge.create("E", "F", 2)
                }
        );

        System.out.println(prim.stream().map(m -> "(" + m[0] + " -> " + m[1] + ")").collect(Collectors.joining(";")));

    }
}