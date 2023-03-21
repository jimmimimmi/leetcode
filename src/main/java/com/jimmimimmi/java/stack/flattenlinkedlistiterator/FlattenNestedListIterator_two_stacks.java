package com.jimmimimmi.java.stack.flattenlinkedlistiterator;

import java.util.*;

public class FlattenNestedListIterator_two_stacks implements Iterator<Integer> {

    private final Deque<Integer> indexes;
    private final Deque<List<NestedInteger>> lists;

    public FlattenNestedListIterator_two_stacks(List<NestedInteger> nestedList) {
        indexes = new ArrayDeque<Integer>();
        lists = new ArrayDeque<List<NestedInteger>>();
        if (nestedList != null && !nestedList.isEmpty()) {
            indexes.addFirst(0);
            lists.addFirst(nestedList);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        var index = indexes.removeFirst();
        var currentList = lists.peekFirst().get(index);
        indexes.addFirst(index + 1);
        return currentList.getInteger();
    }

    @Override
    public boolean hasNext() {
        if (indexes.isEmpty()) return false;

        if (indexes.peekFirst() >= lists.peekFirst().size()) {
            indexes.removeFirst();
            lists.removeFirst();
            return hasNext();
        }

        if (lists.peekFirst().get(indexes.peekFirst()).isInteger()) return true;
        else {
            var index = indexes.removeFirst();
            indexes.addFirst(index + 1);
            indexes.addFirst(0);
            var currentList = lists.peekFirst().get(index);
            lists.addFirst(currentList.getList());
            return hasNext();
        }
    }
}