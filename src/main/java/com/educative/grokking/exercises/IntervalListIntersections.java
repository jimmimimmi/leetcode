package com.educative.grokking.exercises;

import com.educative.grokking.templates.Interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static List<Interval> intervalsIntersection(List<Interval> intervalLista, List<Interval> intervalListb) {
        List<Interval> intersections = new ArrayList<>(); // to store all intersecting intervals
        int left = 0;
        int right = 0;
        while (left < intervalLista.size() && right < intervalListb.size()) {
            var leftInterval = intervalLista.get(left);
            var rightInterval = intervalListb.get(right);
            if (Math.max(leftInterval.getStart(), rightInterval.getStart()) <= Math.min(leftInterval.getEnd(), rightInterval.getEnd())) {
                intersections.add(new Interval(Math.max(leftInterval.getStart(), rightInterval.getStart()), Math.min(leftInterval.getEnd(), rightInterval.getEnd())));
            }
            if (leftInterval.getEnd() == rightInterval.getEnd()) {
                left++;
                right++;
            } else if (leftInterval.getEnd() < rightInterval.getEnd()) {
                left++;
            } else {
                right++;
            }

        }
        return intersections;
    }
}
