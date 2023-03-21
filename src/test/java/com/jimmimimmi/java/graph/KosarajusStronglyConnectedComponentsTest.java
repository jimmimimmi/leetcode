package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class KosarajusStronglyConnectedComponentsTest extends TestCase {

    public void testGetScc() {
        var result = new KosarajusStronglyConnectedComponents().getScc(
                new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"},
                new String[][]{
                        {"A", "B"},
                        {"B", "C"},
                        {"C", "A"},

                        {"B", "D"},
                        {"D", "E"},
                        {"E", "F"},
                        {"F", "D"},

                        {"G", "F"},
                        {"G", "H"},
                        {"H", "I"},
                        {"I", "J"},
                        {"J", "G"},

                        {"J", "K"},

                }

        );

        var resultString =
                result.stream()
                        .map(l -> String.join(",", l))
                        .collect(Collectors.joining("\n"));
        System.out.println(resultString);
    }
}