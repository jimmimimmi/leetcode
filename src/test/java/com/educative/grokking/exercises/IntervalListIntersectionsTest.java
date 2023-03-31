package com.educative.grokking.exercises;

import com.educative.grokking.templates.Interval;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

import java.util.List;

public class IntervalListIntersectionsTest extends TestCase {

    public void testIntervalsIntersection() throws JsonProcessingException {
        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                IntervalListIntersections.intervalsIntersection(
                                        List.of(new Interval(1, 4),
                                                new Interval(5, 6),
                                                new Interval(7, 8),
                                                new Interval(9, 15)),
                                        List.of(new Interval(2, 4),
                                                new Interval(5, 7),
                                                new Interval(9, 15))
                                )));
    }
}