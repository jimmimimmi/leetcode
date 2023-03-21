package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class BellmanFordSingleSourceShortestPathTest extends TestCase {

    public void testGetShortestPath() {
        var result = new BellmanFordSingleSourceShortestPath().getShortestPath(
                "S",
                new String[]{"R", "S", "T", "X", "Y", "Z"},
                new BellmanFordSingleSourceShortestPath.Edge[]{
                        new BellmanFordSingleSourceShortestPath.Edge("R", "T", 3),
                        new BellmanFordSingleSourceShortestPath.Edge("R", "S", 5),
                        new BellmanFordSingleSourceShortestPath.Edge("T", "Z", 2),
                        new BellmanFordSingleSourceShortestPath.Edge("T", "Y", 4),
                        new BellmanFordSingleSourceShortestPath.Edge("T", "X", 7),
                        new BellmanFordSingleSourceShortestPath.Edge("X", "Y", -1),
                        new BellmanFordSingleSourceShortestPath.Edge("Y", "Z", -2),
                        new BellmanFordSingleSourceShortestPath.Edge("S", "T", 2),
                        new BellmanFordSingleSourceShortestPath.Edge("S", "X", 6)
                }
        );
        System.out.println(result.stream().map(m -> "(" + m.from + " -> " + m.to + ": " + m.weight + ")").collect(Collectors.joining(";")));

    }
}