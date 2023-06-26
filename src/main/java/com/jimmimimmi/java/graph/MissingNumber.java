package com.jimmimimmi.java.graph;

/*
Given an array, nums, containing n distinct numbers in the range [0,n],
return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    // Tip: You may use some of the code templates provided
    // in the support file
    public static int findMissingNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            var cur = arr[i];
            if (cur == i || cur >= arr.length) {
                continue;
            }
            var another = arr[cur];
            arr[i] = another;
            arr[cur] = cur;
            i--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }
        return arr.length;
    }
}
