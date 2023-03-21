package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TarjanStronglyConnectedComponentsTest extends TestCase {

    public void testGetScc() {
        var nodes = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        var edges = new String[][]{
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

        };
        var tarjan = new TarjanStronglyConnectedComponents().getScc(
                nodes,
                edges
        );
        var kosarajus = new KosarajusStronglyConnectedComponents().getScc(
                nodes,
                edges
        );


        System.out.println(resultToString(kosarajus));
        System.out.println(resultToString(tarjan));
    }

    private String resultToString(List<List<String>> result){
        return result.stream()
                .map(l -> String.join(",", l))
                .collect(Collectors.joining("\n"));
    }
}