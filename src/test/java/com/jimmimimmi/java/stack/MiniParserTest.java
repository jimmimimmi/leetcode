package com.jimmimimmi.java.stack;

import junit.framework.TestCase;

public class MiniParserTest extends TestCase {

    public void testDeserialize() {
        new MiniParser().deserialize("[123,456,[788,799,833],[[]],10,[]]");
    }
}