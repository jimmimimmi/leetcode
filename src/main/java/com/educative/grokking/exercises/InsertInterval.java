package com.educative.grokking.exercises;

import com.educative.grokking.templates.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    // [3-5, 7-10], 1-2  -> [1-2, 3-5, 7-10]
    // [3-5, 7-10], 11-12  -> [3-5, 7-10, 11-12]
    // [3-5, 7-10], 5-7  -> [3-10]
    // [1-2, 7-10], 3-5  -> [1-2, 3-5, 7-10]

    public static List<Interval> insertInterval(List<Interval> l, Interval newInterval) {
        var result = new ArrayList<Interval>();
        if (l == null || l.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        var iterator = l.iterator();

        Interval currInterval = null;
        while (iterator.hasNext()) {
            currInterval = iterator.next();
            if (currInterval.getEnd() < newInterval.getStart()) {
                result.add(currInterval);
            } else {
                break;
            }
        }

        result.add(newInterval);

        if (result.size() > 1 && result.get(result.size() - 2) == currInterval) {
            if (iterator.hasNext()) {
                currInterval = iterator.next();
            } else currInterval = null;
        }

        while (currInterval != null) {
            var prevInterval = result.get(result.size() - 1);
            if (Math.max(prevInterval.getStart(), currInterval.getStart()) <=
                    Math.min(prevInterval.getEnd(), currInterval.getEnd())) {
                var mergedInterval2 = new Interval(
                        Math.min(prevInterval.getStart(), currInterval.getStart()),
                        Math.max(prevInterval.getEnd(), currInterval.getEnd()));
                result.set(result.size() - 1, mergedInterval2);

            } else {
                result.add(currInterval);
            }
            if (iterator.hasNext()) currInterval = iterator.next();
            else currInterval = null;
        }

        return result;

    }
}
