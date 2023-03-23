package com.leetcode;

import junit.framework.TestCase;

public class N253_Meeting_Rooms_IITest extends TestCase {

    public void testMinMeetingRooms() {
        var res1 = N253_Meeting_Rooms_II.minMeetingRooms(new int[][]{
                {0, 30},
                {5, 10},
                {15, 20}
        });
        var res2 = N253_Meeting_Rooms_II.minMeetingRooms(new int[][]{
                {7, 10},
                {2, 4}
        });

        System.out.println(res1);
        System.out.println(res2);
    }
}