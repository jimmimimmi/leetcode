package com.jimmimimmi.java.guidewire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class IteratorOfIterators<T> implements Iterator<T> {

    private Iterator<T[]> rowIterator;
    private Iterator<T> columnIterator;
    private final T[][] initArrays;

    public IteratorOfIterators(T[][] arrays) {
        initArrays = arrays;
        init();
    }

    private void init() {
        if (initArrays == null) {
            rowIterator = emptyIterator();
            columnIterator = emptyIterator();
        } else {
            rowIterator = Arrays.stream(initArrays).iterator();
            moveUntilNext();
        }
    }

    private <K> Iterator<K> emptyIterator() {
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public K next() {
                return null;
            }
        };
    }


    @Override
    public boolean hasNext() {
        return moveUntilNext();
    }

    private boolean moveUntilNext() {
        var stopped = false;
        var doHaveNext = false;
        while (!stopped) {
            if (columnIterator != null && columnIterator.hasNext()) {
                doHaveNext = true;
                stopped = true;
            } else if (rowIterator.hasNext()) {
                T[] nextRow = rowIterator.next();
                if (nextRow != null) columnIterator = Arrays.stream(nextRow).iterator();
                else columnIterator = null;
            } else {
                stopped = true;
            }
        }
        return doHaveNext;
    }

    @Override
    public T next() {
        T result = null;
        var stopped = false;
        while (!stopped) {
            if (moveUntilNext()) {
                result = columnIterator.next();
                if (result != null) stopped = true;
            } else {
                stopped = true;
            }
        }
        return result;
    }
}
