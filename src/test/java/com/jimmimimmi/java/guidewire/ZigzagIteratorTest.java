package com.jimmimimmi.java.guidewire;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigzagIteratorTest extends TestCase {

    public void testName() {
        var zigzagIterator = new ZigzagIterator(Arrays.stream(new int[]{1, 2}).boxed().collect(Collectors.toList()), Arrays.stream(new int[]{3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        System.out.println(zigzagIterator.next());
        System.out.println(zigzagIterator.next());
        System.out.println(zigzagIterator.next());
        System.out.println(zigzagIterator.next());
        System.out.println(zigzagIterator.next());
        System.out.println(zigzagIterator.next());
    }
}