package com.jimmimimmi.java.parentheses;

import junit.framework.TestCase;

import java.util.HashSet;

public class GenerateParentheses_brute_forceTest extends TestCase {

    public void testGenerateParenthesis() {
        var res_2_1 = new HashSet<>(new GenerateParentheses_brute_force().generateParenthesis(2));
        var res_2_2 = new HashSet<>(new GenerateParentheses_backtracking().generateParenthesis(2));
        var res_3_1 = new HashSet<>(new GenerateParentheses_brute_force().generateParenthesis(3));
        var res_3_2 = new HashSet<>(new GenerateParentheses_backtracking().generateParenthesis(3));

        assertEquals(res_2_1, res_2_2);
        assertEquals(res_3_1, res_3_2);
    }
}