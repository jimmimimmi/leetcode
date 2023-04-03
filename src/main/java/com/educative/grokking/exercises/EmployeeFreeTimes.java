package com.educative.grokking.exercises;

import com.educative.grokking.templates.Interval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
You’re given a list containing the schedules of multiple people.
Each person’s schedule is a list of non-overlapping intervals in sorted order.
An interval is specified with the start time and the end time, both being positive integers.
Your task is to find the list of intervals representing the free time for all the people.
We’re not interested in the interval from negative infinity to zero or
from the end of the last scheduled interval in the input to positive infinity.
 */
public class EmployeeFreeTimes {
    public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule) {
        var allIntervals =
                schedule.stream()
                        .flatMap(Collection::stream)
                        .sorted(Comparator.comparingInt(Interval::getStart)).collect(Collectors.toList());
        var latestEndTime = -1;
        List<Interval> ans = new ArrayList<>();
        for (Interval interval : allIntervals) {
            if (latestEndTime == -1) {
                latestEndTime = interval.getEnd();
            } else {
                if (interval.getStart() > latestEndTime) {
                    ans.add(new Interval(latestEndTime, interval.getStart()));
                    latestEndTime = interval.getEnd();
                } else if (interval.getEnd() > latestEndTime) {
                    latestEndTime = interval.getEnd();
                }
            }
        }

        return ans;
    }
}
