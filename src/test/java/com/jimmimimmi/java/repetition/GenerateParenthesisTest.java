package com.jimmimimmi.java.repetition;

import junit.framework.TestCase;

import java.util.List;

public class GenerateParenthesisTest extends TestCase {

    public void testName() {
        var strings = new GenerateParenthesis.GenerateParenthesis_backtracking().generateParenthesis(3);
    }
}