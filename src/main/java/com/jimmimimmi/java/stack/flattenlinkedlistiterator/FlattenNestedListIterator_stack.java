package com.jimmimimmi.java.stack.flattenlinkedlistiterator;

import java.util.*;

public class FlattenNestedListIterator_stack implements Iterator<Integer> {

    private final Deque<NestedInteger> deque;

    public FlattenNestedListIterator_stack(List<NestedInteger> nestedList) {
        deque = new ArrayDeque<>(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return deque.removeFirst().getInteger();
    }


    @Override
    public boolean hasNext() {
        if (deque.isEmpty()) return false;
        if (deque.peekFirst().isInteger()) return true;
        while (!deque.isEmpty() && !deque.peekFirst().isInteger()) {
            var top = deque.removeFirst();

            var list = top.getList();
            if (list.isEmpty()) continue;
            for (int i = list.size() - 1; i >= 0; i--) {
                deque.addFirst(list.get(i));
            }
        }
        return !deque.isEmpty();
    }
}
