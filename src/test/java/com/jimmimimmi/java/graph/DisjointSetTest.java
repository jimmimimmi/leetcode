package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DisjointSetTest extends TestCase {

    public void testCountDisjointSets() {
        var count2 = new DisjointSet<String>().countDisjointSets(new HashMap<>() {
            {
                put("A", Arrays.asList("B"));
                put("B", Arrays.asList("C", "A"));
                put("C", Collections.singletonList("B"));
                put("D", Arrays.asList("E"));
                put("E", Arrays.asList("D"));
            }
        });
        System.out.println(count2);

        var count1 = new DisjointSet<String>().countDisjointSets(new HashMap<>() {
            {
                put("A", Arrays.asList("B", "E"));
                put("B", Arrays.asList("C", "A"));
                put("C", Collections.singletonList("B"));
                put("D", Arrays.asList("E"));
                put("E", Arrays.asList("D", "A"));
            }
        });
        System.out.println(count1);
    }
}