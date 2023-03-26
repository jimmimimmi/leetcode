package com.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

public class N986_Interval_List_IntersectionsTest extends TestCase {

    public void testIntervalIntersection() throws JsonProcessingException {
        System.out.println(new ObjectMapper()
                .writeValueAsString(N986_Interval_List_Intersections.intervalIntersection(
                        new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                        new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }
}