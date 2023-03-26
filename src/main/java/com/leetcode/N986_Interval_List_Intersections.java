package com.leetcode;

/*
986. Interval List Intersections
Medium
5K
98
company
Yandex
company
Facebook
company
Uber
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 Example 1:
 Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

 */

import java.util.ArrayList;

public class N986_Interval_List_Intersections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // two pointers. both points to the 0 indexes of each array
        // Loop ============= (while both pointers are within arrays boundaries)
        // compare corresponded intervals pointed by pointers
        // IF they do not overlap -
        // take that one which ends prior the another and put it into the result array, then move the respected pointer forward
        // ELSE - put into result array overlapped interval
        // Then decide which pointers should be moved forward
        // IF both intervals end at the same point, move both pointers
        // ELSE move forward that pointer which points to the interval ending prior another one

        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[0][];
        }

        var firstP = 0;
        var secondP = 0;

        var result = new ArrayList<int[]>();
        while (firstP < firstList.length && secondP < secondList.length) {
            var interval1 = firstList[firstP];
            var interval2 = secondList[secondP];

            /*
             new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
             new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
             */

            if (!areOverlapping(interval1, interval2)) {
                if (interval1[1] > interval2[1]) {
                    secondP++;
                } else {
                    firstP++;
                }
            } else {
                var overlapping = getOverlapping(interval1, interval2);
                result.add(overlapping);
                if (interval1[1] == interval2[1]) {
                    firstP++;
                    secondP++;
                } else if (interval1[1] < interval2[1]) {
                    firstP++;
                } else {
                    secondP++;
                }
            }

        }
        var r = new int[result.size()][];
        result.toArray(r);
        return r;
    }

    private static boolean areOverlapping(int[] left, int[] right) {
        return Math.max(left[0], right[0]) <= Math.min(left[1], right[1]);
    }

    private static int[] getOverlapping(int[] left, int[] right) {
        return new int[]{Math.max(left[0], right[0]), Math.min(left[1], right[1])};
    }


}
