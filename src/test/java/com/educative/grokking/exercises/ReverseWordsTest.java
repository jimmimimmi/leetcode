package com.educative.grokking.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import junit.framework.TestCase;

public class ReverseWordsTest extends TestCase {

    public void testReverseWords() throws JsonProcessingException {
        System.out.println(ReverseWords.reverseWords("hey, how are you doing?"));
        System.out.println(ReverseWords.reverseWords("hey,   how   are   you   doing?"));
        System.out.println(ReverseWords.reverseWords(" hey,   how   are   you   doing? "));
    }
}