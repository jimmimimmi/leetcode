package com.jimmimimmi.java.stack;

import junit.framework.TestCase;

public class BasicCalculatorTest extends TestCase {

    public void xtestCalculate() {
        assertEquals(23, new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        assertEquals(23, new BasicCalculator().calculate("( 1+ ( 4 + 5 - 2) - 3) + ( 6 + 8 ) + 2"));
    }
}