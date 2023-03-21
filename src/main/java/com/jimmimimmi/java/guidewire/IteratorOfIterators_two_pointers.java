package com.jimmimimmi.java.guidewire;

import java.util.Iterator;

public class IteratorOfIterators_two_pointers<T> implements Iterator<T> {

    private final T[][] arrays;
    private int rowIndex = 0;
    private int columnIndex = 0;

    public IteratorOfIterators_two_pointers(T[][] arrays) {
        this.arrays = arrays;
    }

    public boolean hasNext_recursive() {
        if (arrays == null) return false;
        while (rowIndex < arrays.length &&
                (arrays[rowIndex] == null || columnIndex == arrays[rowIndex].length)) {
            rowIndex++;
            columnIndex = 0;
        }

        if (rowIndex == arrays.length) return false;
        if (arrays[rowIndex][columnIndex] == null) {
            columnIndex++;
            return hasNext();
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        if (arrays == null || rowIndex == arrays.length) return false;
        while (true) {
            while (rowIndex < arrays.length &&
                    (arrays[rowIndex] == null || columnIndex == arrays[rowIndex].length)) {
                rowIndex++;
                columnIndex = 0;
            }

            if (rowIndex == arrays.length) return false;

            if (arrays[rowIndex][columnIndex] == null) columnIndex++;
            else return true;
        }
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        var result = arrays[rowIndex][columnIndex];
        columnIndex++;
        return result;
    }
}
