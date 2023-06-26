package com.jimmimimmi.java.graph;

import java.util.ArrayList;
import java.util.List;

public class FindTheFirstKMissingPositiveNumbers {
    // [2, 4, 5], 3 => 1, 2, 3, 4, 5, 6
    public static List<Integer> firstKMissingNumbers(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            var curVal = arr[i];
            var expectedIdx = curVal - 1;
            if (expectedIdx < arr.length && expectedIdx >= 0 && curVal != arr[expectedIdx]) {
                arr[i] = arr[expectedIdx];
                arr[expectedIdx] = curVal;
                i--;
            }
        }
        // [4, 5, 6], 3 => [1, 2, 3]

        var result = new ArrayList<Integer>();
        var curIndex = 0;
        while (result.size() < k) {
            if (curIndex >= arr.length || curIndex + 1 != arr[curIndex]) {
                result.add(curIndex + 1);
            }
            curIndex++;
        }

        return result;
    }
}
