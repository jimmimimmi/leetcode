package com.jimmimimmi.java.recursion;

import junit.framework.TestCase;

import java.util.List;
import java.util.stream.Collectors;

public class PermutationsTest extends TestCase {

    public void testPermute() {
        var result1 = new Permutations()
                .permute(new int[]{1, 2, 3, 4})
                .stream()
                .map(integers -> integers.stream().map(Object::toString).collect(Collectors.joining(",")))
                .map(s -> "[" + s + "]").collect(Collectors.joining("\n"));
        System.out.println(result1);
    }
}