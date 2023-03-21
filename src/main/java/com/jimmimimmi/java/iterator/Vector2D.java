package com.jimmimimmi.java.iterator;

import java.util.NoSuchElementException;

class Vector2D {

    private final int[][] v;
    private int rowIndex = 0;
    private int columnIndex = 0;

    public Vector2D(int[][] v) {
        this.v = v;
    }

    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        var result = v[rowIndex][columnIndex];
        columnIndex++;
        return result;
    }

    public boolean hasNext() {
        while (rowIndex < v.length && columnIndex == v[rowIndex].length) {
            rowIndex++;
            columnIndex = 0;
        }
        return rowIndex < v.length && columnIndex < v[rowIndex].length;
    }
}