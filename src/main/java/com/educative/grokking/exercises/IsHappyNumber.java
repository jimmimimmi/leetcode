package com.educative.grokking.exercises;

public class IsHappyNumber {
    public static int sumDigits(int number) {
        int totalSum = 0;
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        return totalSum;
    }

    public static boolean isHappyNumber(int n) {

        int left = n;
        int right = sumDigits(n);
        while (true) {
            if (left == 1 || right == 1) {
                return true;
            } else if (left == right) {
                return false;
            } else {
                left = sumDigits(left);
                right = sumDigits(sumDigits(right));
            }
        }
    }
}
