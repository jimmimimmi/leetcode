package com.jimmimimmi.java.graph;

import junit.framework.TestCase;

public class MissingNumberTest extends TestCase {

    public void testFindMissingNumber() {
        System.out.println(MissingNumber.findMissingNumber(new int[]{1, 4, 5, 6, 8, 2, 0, 7}));
    }
}