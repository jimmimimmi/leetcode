package com.jimmimimmi.java.iterator;

import java.util.*;

//https://leetcode.com/problems/peeking-iterator/
/*
284. Peeking Iterator
Medium

440

299

Add to List

Share
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element.
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer toBeNext = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) throw new NoSuchElementException();
        return toBeNext;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        var res = toBeNext;
        toBeNext = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        reInit();
        return toBeNext != null;
    }

    private void reInit() {
        while (toBeNext == null && iterator.hasNext()) {
            toBeNext = iterator.next();
        }
    }
}
