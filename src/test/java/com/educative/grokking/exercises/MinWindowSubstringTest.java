package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class MinWindowSubstringTest extends TestCase {

    public void testMinWindow() {
        System.out.println(MinWindowSubstring.minWindow("BACBABAD", "DAA"));
        System.out.println(MinWindowSubstring.minWindow("ABXYZJKLSNFC", "ABC"));
        System.out.println(MinWindowSubstring.minWindow("AAAAAAAAAAA", "A"));
        System.out.println(MinWindowSubstring.minWindow("ABDFGDCKAB", "ABCD"));
        System.out.println(MinWindowSubstring.minWindow("XYZYX", "XYZ"));
    }
}