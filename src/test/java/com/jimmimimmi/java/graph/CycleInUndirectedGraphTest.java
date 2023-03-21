package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

public class CycleInUndirectedGraphTest extends TestCase {

    public void testHasCycle() {
        var thereIsCycle = new CycleInUndirectedGraph().hasCycle(
                new String[]{"A", "B", "C", "D", "E", "F"},
                new String[][]{
                        {"A", "B"},
                        {"A", "D"},
                        {"A", "E"},
                        {"B", "C"},
                        {"E", "F"},
                        {"D", "F"}
                }
        );
        System.out.println(thereIsCycle);

        var thereIsNoCycle = new CycleInUndirectedGraph().hasCycle(
                new String[]{"A", "B", "C", "D", "E", "F"},
                new String[][]{
                        {"A", "B"},
                        {"A", "D"},
                        {"A", "E"},
                        {"B", "C"},
                        {"E", "F"},
                }
        );
        System.out.println(thereIsNoCycle);
    }
}