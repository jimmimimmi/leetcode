package com.jimmimimmi.java.arrays;

/*
This is a demo task.

Write a function:
class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

import java.util.Arrays;

public class NextPositiveNUmber {
    public int solution(int[] A) {
        // write your code in Java SE 11
        if (A == null || A.length == 0) return 1;

        Arrays.sort(A);
        int nextExpected = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < nextExpected) continue;
            if (A[i] == nextExpected) {
                nextExpected++;
                continue;
            }
            if (A[i] > nextExpected) return nextExpected;
        }
        return nextExpected;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 11
        if (A == null || A.length == 0) return 1;

        var shift = 1_000_000;
        var aux = new int[2 * shift + 1];
        for (int i = 0; i < A.length; i++) {
            aux[A[i] + shift] = A[i];
        }
        for (int i = 1; i < shift + 1; i++) {
            if (aux[i + shift] != i) return i;
        }
        return shift + 1;
    }
}
