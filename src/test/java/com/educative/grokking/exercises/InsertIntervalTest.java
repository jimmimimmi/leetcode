package com.educative.grokking.exercises;

import com.educative.grokking.templates.Interval;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

import java.util.List;

public class InsertIntervalTest extends TestCase {

    public void testInsertInterval() throws JsonProcessingException {
        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                InsertInterval.insertInterval(
                                        List.of(new Interval(1, 4), new Interval(6, 8)),
                                        new Interval(10, 12))));
        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                InsertInterval.insertInterval(
                                        List.of(new Interval(3, 4), new Interval(6, 8)),
                                        new Interval(1, 2))));


        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                InsertInterval.insertInterval(
                                        List.of(new Interval(3, 4), new Interval(6, 8)),
                                        new Interval(1, 3))));
        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                InsertInterval.insertInterval(
                                        List.of(new Interval(3, 4), new Interval(6, 8)),
                                        new Interval(4, 5))));
        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                InsertInterval.insertInterval(
                                        List.of(new Interval(3, 4), new Interval(6, 8)),
                                        new Interval(8, 9))));
        System.out.println(
                new ObjectMapper()
                        .writeValueAsString(
                                InsertInterval.insertInterval(
                                        List.of(new Interval(3, 4), new Interval(6, 8)),
                                        new Interval(1, 9))));


    }
}