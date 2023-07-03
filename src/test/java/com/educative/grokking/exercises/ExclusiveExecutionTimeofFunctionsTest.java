package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.List;

public class ExclusiveExecutionTimeofFunctionsTest extends TestCase {

    public void testExclusiveTime() {
        System.out.println(ExclusiveExecutionTimeofFunctions.exclusiveTime(2, List.of("0:start:0", "1:start:3", "1:end:6", "0:end:10")));
    }
}