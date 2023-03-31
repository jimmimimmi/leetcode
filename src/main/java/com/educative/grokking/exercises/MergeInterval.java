package com.educative.grokking.exercises;

import com.educative.grokking.templates.Interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeInterval {
    public static List<Interval> mergeIntervals(List<Interval> l) {
        if (l == null || l.isEmpty()) return l;
        var iterator = l.iterator();
        var result = new ArrayList<Interval>();
        while (iterator.hasNext()) {
            var currInterval = iterator.next();
            if (result.isEmpty()) {
                result.add(currInterval);
            } else {
                var prevInterval = result.get(result.size() - 1);
                if (Math.max(prevInterval.getStart(), currInterval.getStart()) <=
                        Math.min(prevInterval.getEnd(), currInterval.getEnd())) {
                    var mergedInterval = new Interval(
                            Math.min(prevInterval.getStart(), currInterval.getStart()),
                            Math.max(prevInterval.getEnd(), currInterval.getEnd()));
                    result.set(result.size() - 1, mergedInterval);

                } else {
                    result.add(currInterval);
                }
            }

        }
        return result;
    }
}
