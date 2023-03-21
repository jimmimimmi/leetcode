package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.List;
import java.util.stream.Collectors;

public class DjkstraSingleSourceShortestPathTest extends TestCase {

    public void testGetMinimumSpanningTreeEdges() {
        var result = new DjkstraSingleSourceShortestPath().getMinimumSpanningTreeEdges("A",
                new String[]{"A", "B", "C", "D", "E", "F"},
                new DjkstraSingleSourceShortestPath.Edge[]{
                        new DjkstraSingleSourceShortestPath.Edge("A", "B", 5),
                        new DjkstraSingleSourceShortestPath.Edge("A", "E", 2),
                        new DjkstraSingleSourceShortestPath.Edge("A", "D", 9),
                        new DjkstraSingleSourceShortestPath.Edge("B", "C", 2),
                        new DjkstraSingleSourceShortestPath.Edge("C", "D", 3),
                        new DjkstraSingleSourceShortestPath.Edge("D", "F", 2),
                        new DjkstraSingleSourceShortestPath.Edge("E", "F", 3)
                }

        );


        System.out.println(result.stream().map(m -> "(" + m.from + " -> " + m.to + ": " + m.weight + ")").collect(Collectors.joining(";")));

    }
}