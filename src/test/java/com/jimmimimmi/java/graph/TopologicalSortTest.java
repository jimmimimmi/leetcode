package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSortTest extends TestCase {

    public void testSort() {
        var sort1 = new TopologicalSort<String>().sort(new HashMap<>() {
            {
                put("A", Collections.singletonList("C"));
                put("B", Arrays.asList("C", "D"));
                put("C", Collections.singletonList("E"));
                put("D", Arrays.asList("F"));
                put("E", Arrays.asList("F", "H"));
                put("F", Arrays.asList("G"));
            }
        });
        System.out.println(sort1.stream().collect(Collectors.joining(",")));
    }
}