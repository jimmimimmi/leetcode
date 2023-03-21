package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class FloydWarshallAllPairsShortesPathTest extends TestCase {

    public void testGetShortestPath() {
        var result = new FloydWarshallAllPairsShortesPath().getShortestPath(
                new String[]{"0", "1", "2", "3"},
                new FloydWarshallAllPairsShortesPath.Edge[]{
                        new FloydWarshallAllPairsShortesPath.Edge("0", "1", 3),
                        new FloydWarshallAllPairsShortesPath.Edge("0", "2", 1),
                        new FloydWarshallAllPairsShortesPath.Edge("0", "3", 15),
                        new FloydWarshallAllPairsShortesPath.Edge("1", "2", -2),
                        new FloydWarshallAllPairsShortesPath.Edge("2", "3", 2),
                        new FloydWarshallAllPairsShortesPath.Edge("3", "0", 1)
                }, "3", "2"
        );

        System.out.println("size: " + result.size() + ", " + result.stream().map(m -> m).collect(Collectors.joining(" ->")));

    }
}