package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

public class CycleInDirectedGraphTest extends TestCase {

    public void testHasCycle() {
       var thereIsCycle = new CycleInDirectedGraph().hasCycle(
               new String[]{"A", "B", "C", "D", "E", "F"},
                new String[][]{
                        {"A", "B"},
                        {"A", "C"},
                        {"B", "C"},
                        {"B", "D"},
                        {"C", "E"},
                        {"D", "E"},
                        {"D", "F"},
                        {"F", "C"},
                        {"C", "D"},
                }
                );
        System.out.println(thereIsCycle);

        var thereIsNoCycle = new CycleInDirectedGraph().hasCycle(
               new String[]{"A", "B", "C", "D", "E", "F"},
                new String[][]{
                        {"A", "B"},
                        {"A", "C"},
                        {"B", "C"},
                        {"B", "D"},
                        {"C", "E"},
                        {"D", "E"},
                        {"D", "F"},
                        {"F", "C"},
                }
                );
        System.out.println(thereIsNoCycle);
    }
}