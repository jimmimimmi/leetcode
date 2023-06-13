package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIPAddresses {

    private static boolean isValid(String s, int segmentStart, int segmentEnd, int segmentsLeft) {
        // 2552552551
        if (segmentsLeft < 1) return false;
        if (segmentStart >= s.length()) return false;
        if (segmentEnd > s.length()) return false;
        var segment = s.substring(segmentStart, segmentEnd);
        if (segment.charAt(0) == '0' && segment.length() > 1) return false;
        if (Integer.parseInt(segment) > 255) return false;

        return true;
    }

    private static ArrayList<List<Integer>> explore(String s, int segmentStart, int segmentEnd, int segmentsLeft) {
        if (!isValid(s, segmentStart, segmentEnd, segmentsLeft)) {
            return null;
        }

        var segment = Integer.parseInt(s.substring(segmentStart, segmentEnd));
        if (segmentEnd == s.length() && segmentsLeft == 1) {
            var res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<>());
            res.get(0).add(segment);
            return res;
        }

        var result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= 3; i++) {
            var nextEnd = segmentEnd + i;
            var explore = explore(s, segmentEnd, nextEnd, segmentsLeft - 1);
            if (explore != null) {
                for (List<Integer> subsegments : explore) {
                    var segments = new ArrayList<Integer>();
                    segments.add(segment);
                    segments.addAll(subsegments);
                    result.add(segments);
                }
            }
        }
        return result;
    }

    public static List<String> restoreIpAddresses(String s) {

        var segments = new ArrayList<List<Integer>>();
        for (int i = 1; i <= 3; i++) {
            var explore = explore(s, 0, i, 4);
            if (explore != null)
                for (List<Integer> listSegments : explore) {
                    if (listSegments.size() == 4) {
                        var sss = new ArrayList<Integer>(listSegments);
//                        Collections.reverse(sss);
                        segments.add(sss);
                    }
                }
        }

        var result = new ArrayList<String>();
        for (List<Integer> segmentValues : segments) {
            var segmentString = segmentValues.stream().map(Object::toString).collect(Collectors.joining("."));
            result.add(segmentString);
        }

        return result;
    }
}
