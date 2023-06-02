package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class MinimumNumberOfRefuelingStopsTest extends TestCase {

    public void testMinRefuelStops() {
        System.out.println(MinimumNumberOfRefuelingStops.minRefuelStops(
                120, 10, new int[][]{{10, 60}, {20, 25}, {30, 30}, {60, 40}}));
    }
}