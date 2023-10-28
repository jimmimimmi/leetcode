package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.Arrays;

public class EvaluateDivisionTest extends TestCase {

    public void testCalcEquation() {
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(Arrays.asList(
                        Arrays.asList("a", "b"), //2  a/b=2 => a = 2b
                        Arrays.asList("b", "c") //2  b = 2c
                       // Arrays.asList("a", "d")  //2  d = 2a
                ), new double[]{2, 2, 4},
                Arrays.asList(
                        Arrays.asList("c", "a")//, //2
//                        Arrays.asList("d", "b") //2
//                        Arrays.asList("b", "a"), //2
//                        Arrays.asList("a", "d"), //2
//                        Arrays.asList("d", "a"),
//                        Arrays.asList("d", "c")
                ))));
    }
}