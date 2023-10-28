package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class LastDayWhereYouCanStillCrossTest extends TestCase {

    public void testLastDayToCross() {
        LastDayWhereYouCanStillCross.lastDayToCross(3, 4,
                new int[][]{
                        {2, 4},
                        {1, 3},
                        {3, 3},
                        {2, 1},
                        {2, 3},
                        {2, 2},
                        {1, 4},
                        {3, 1},
                        {1, 1},
                        {1, 2},
                        {3, 2},
                        {3, 4}});
    }
}