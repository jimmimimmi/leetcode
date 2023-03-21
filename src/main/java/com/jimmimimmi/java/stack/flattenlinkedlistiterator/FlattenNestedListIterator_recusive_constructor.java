package com.jimmimimmi.java.stack.flattenlinkedlistiterator;
//https://leetcode.com/problems/flatten-nested-list-iterator/
/*
341. Flatten Nested List Iterator
Medium

1521

618

Add to List

Share
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,4,6].
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class FlattenNestedListIterator_recusive_constructor implements Iterator<Integer> {

    private final Iterator<Integer> internalIterator;

    private void addToList(List<Integer> flattenList, NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            flattenList.add(nestedInteger.getInteger());
        } else {
            var subList = nestedInteger.getList();
            for (NestedInteger n : subList) {
                addToList(flattenList, n);
            }
        }
    }

    public FlattenNestedListIterator_recusive_constructor(List<NestedInteger> nestedList) {
        var flattenList = new ArrayList<Integer>();
        for (NestedInteger n : nestedList) {
            addToList(flattenList, n);
        }
        internalIterator = flattenList.iterator();
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return internalIterator.next();
    }

    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }
}
