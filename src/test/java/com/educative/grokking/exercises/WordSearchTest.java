package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class WordSearchTest extends TestCase {

    public void testWordSearch() {
        System.out.println(WordSearch.wordSearch(
                new char[][]
                        {{'N', 'W', 'L', 'I', 'M'},
                                {'V', 'I', 'L', 'Q', 'O'},
                                {'O', 'L', 'A', 'T', 'O'},
                                {'R', 'T', 'A', 'I', 'N'},
                                {'O', 'I', 'T', 'N', 'C'}}, "LATIN"));

    }
}