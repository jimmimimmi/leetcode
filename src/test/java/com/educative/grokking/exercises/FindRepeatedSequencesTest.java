package com.educative.grokking.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

public class FindRepeatedSequencesTest extends TestCase {

    public void testFindRepeatedSequences_rollingHashing() throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString( FindRepeatedSequences.findRepeatedSequences_rollingHashing("AAAAACCCCCAAAAACCCCCC", 8)));
    }
}