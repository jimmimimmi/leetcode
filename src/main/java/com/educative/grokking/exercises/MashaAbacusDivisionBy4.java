package com.educative.grokking.exercises;

public class MashaAbacusDivisionBy4 {
    public static void divideByAnyNumber(long number, int divisor) {

        var result = (double) number / divisor;

        var resultString=String.format("Result is %f",result);
        System.out.println(resultString);
    }
}
