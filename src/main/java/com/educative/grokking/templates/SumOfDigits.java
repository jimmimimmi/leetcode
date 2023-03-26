package com.educative.grokking.templates;

public class SumOfDigits {
    public static int sumDigits(int number) {
        int totalSum = 0;
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        return totalSum;
    }
}
