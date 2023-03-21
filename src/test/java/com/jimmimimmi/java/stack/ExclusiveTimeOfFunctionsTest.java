package com.jimmimimmi.java.stack;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ExclusiveTimeOfFunctionsTest extends TestCase {

    public void testExclusiveTime() {
        new ExclusiveTimeOfFunctions().exclusiveTime(2,
                Arrays.stream(new String[]{"0:start:0","1:start:1","1:end:4","0:end:6"}).collect(Collectors.toList()));
    }
}