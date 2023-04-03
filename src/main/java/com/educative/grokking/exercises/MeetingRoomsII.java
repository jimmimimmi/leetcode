package com.educative.grokking.exercises;

/*
 [[1, 3], [2, 6], [8, 10], [9, 15], [12, 14]]

 ---
  -----
        ---
         -------
            ---

sort all intervals by startTime
have a deque
before adding a curr interval to the back remove from the front all intervals which do not overlap current
pu current into back of the queue and check the queue size.
Carry the maximum queue size after adding every particular interval.

Time complexity is O(n*log(n))
Space complexity is O(n)
 */

import com.educative.grokking.templates.Interval;

import java.util.*;

public class MeetingRoomsII {
    public static int minMeetingRooms(List<Interval> meetingTimes) {
        var result = 0;
        var sortedMeetings = new ArrayList<>(meetingTimes);
        sortedMeetings.sort(Comparator.comparingInt(Interval::getEnd));

        var deque = new ArrayDeque<Interval>();
        for(Interval interval: sortedMeetings){
            while (!deque.isEmpty() && deque.peekFirst().getEnd()<=interval.getStart()){
                deque.removeFirst();
            }
            deque.addLast(interval);
            result = Math.max(result, deque.size());
        }

        return result;
    }
}
