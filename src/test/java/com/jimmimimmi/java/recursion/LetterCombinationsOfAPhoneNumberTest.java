package com.jimmimimmi.java.recursion;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumberTest extends TestCase {

    public void testLetterCombinations() {
        System.out.println(String.join(",", new LetterCombinationsOfAPhoneNumber().letterCombinations("23")));
    }
}