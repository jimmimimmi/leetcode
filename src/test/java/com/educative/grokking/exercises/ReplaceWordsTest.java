package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReplaceWordsTest extends TestCase {

    public void testReplaceWords() {
//        System.out.println(new ReplaceWords().replaceWords(Arrays.stream(new String[]{"ca"}).collect(Collectors.toList()), "cat cab"));
        System.out.println(new ReplaceWords().replaceWords(Arrays.stream(new String[]{"wi", "wa", "w"}).collect(Collectors.toList()), "where there is a will there is a way"));
    }
}