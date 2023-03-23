package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/*
253. Meeting Rooms II
Medium
6.4K
136
company
Bloomberg
company
Amazon
company
Apple
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

[0,30], [5,10], [12,20] => 2

[0,5], [4,10], [7,20] => 1

0---20
0-------------------30
   5---10
           12---20

0-5 => 1
4-10 => 2
7-8 => 2
7-9 => 3
9-11

0-30
5-0
0-0


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106



 */
public class N253_Meeting_Rooms_II {
    public static int minMeetingRooms(int[][] intervals) {
        var queue = new PriorityQueue<Integer>();
        AtomicInteger max = new AtomicInteger();
        Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(o -> o[0]))
                .forEach(interval -> {
                    var start = interval[0];
                    var end = interval[1];
                    while (queue.peek() != null && queue.peek()<=start) {
                        queue.poll();
                    }
                    queue.offer(end);
                    max.set(Math.max(max.get(), queue.size()));
                });
        return max.get();
    }
}
