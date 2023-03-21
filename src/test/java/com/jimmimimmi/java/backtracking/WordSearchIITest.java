package com.jimmimimmi.java.backtracking;

import junit.framework.TestCase;

import java.util.List;

public class WordSearchIITest extends TestCase {

    public void testName() {

        var foundWords = new WordSearchII().findWords(new char[][]{
                        {'a', 'b', 'c'},
                        {'d', 'e', 'f'},
                        {'g', 'h', 'i'}},
                new String[]{"abc", "abe", "abeh", "ihe", "ihi"});

        myAssert(foundWords.stream().anyMatch(s -> s.equals("abc")));
        myAssert(foundWords.stream().anyMatch(s -> s.equals("abe")));
        myAssert(foundWords.stream().anyMatch(s -> s.equals("abeh")));
        myAssert(foundWords.stream().anyMatch(s -> s.equals("ihe")));
        myAssert(foundWords.stream().noneMatch(s -> s.equals("ihi")));
    }

    private void myAssert(boolean expected) {
        if (!expected) throw new RuntimeException("");
    }
}
