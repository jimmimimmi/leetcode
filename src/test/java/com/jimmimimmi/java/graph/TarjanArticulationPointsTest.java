package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class TarjanArticulationPointsTest extends TestCase {

    public void testGetArticulationPoints() {
        var result1 = new TarjanArticulationPoints().getArticulationPoints(
                new String[]{"A", "B", "C", "D", "E", "F", "G", "H"},
                new String[][]{
                        {"A", "B"},
                        {"B", "C"},
                        {"C", "A"},

                        {"C", "D"},
                        {"D", "E"},

                        {"E", "F"},
                        {"E", "G"},
                        {"F", "G"},

                        {"H", "F"}
                }
        );

        System.out.println(result1.stream().collect(Collectors.joining(",")));

        var result2 = new TarjanArticulationPoints().getArticulationPoints(
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
        System.out.println(result2.stream().collect(Collectors.joining(",")));

    }
}