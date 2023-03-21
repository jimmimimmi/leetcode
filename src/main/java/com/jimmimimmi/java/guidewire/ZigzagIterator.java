package com.jimmimimmi.java.guidewire;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

//https://leetcode.com/problems/zigzag-iterator/
/*
281. Zigzag Iterator
Medium

350

20

Add to List

Share
Given two 1d vectors, implement an iterator to return their elements alternately.



Example:

Input:
v1 = [1,2]
v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].


Follow up:

What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question:
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:

Input:
[1,2,3]
[4,5,6,7]
[8,9]

Output: [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {

    private int rowIndex = 0;
    private int[] columnIndexes = new int[]{0, 0};
    private int exhaustedRows = 0;
    private final List<Integer>[] lists;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new List[]{v1, v2};
    }

    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        var listIdx = columnIndexes[rowIndex];
        var result = lists[rowIndex].get(listIdx);
        columnIndexes[rowIndex]++;
        rowIndex = (rowIndex + 1) % lists.length;
        return result;
    }

    public boolean hasNext() {
        if (exhaustedRows == lists.length) return false;

        while (columnIndexes[rowIndex] == lists[rowIndex].size()) {
            exhaustedRows++;
            if (exhaustedRows == lists.length) return false;
            columnIndexes[rowIndex] = -1;
            rowIndex = (rowIndex + 1) % lists.length;
        }

        if (columnIndexes[rowIndex] == -1) {
            rowIndex = (rowIndex + 1) % lists.length;
            return hasNext();
        }
        return true;
    }
}
