package com.jimmimimmi.java.recursion;

import com.jimmimimmi.java.recursion.DecodeString;
import junit.framework.TestCase;

public class DecodeStringTest extends TestCase {

    public void testDecodeString() {
        System.out.println("result \"3[a]2[bc]\": " + new DecodeString().decodeString("3[a]2[bc]"));
    }
}