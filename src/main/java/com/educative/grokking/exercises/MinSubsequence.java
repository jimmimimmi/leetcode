package com.educative.grokking.exercises;

/*
Given strings str1 and str2, find the minimum (contiguous) substring subStr of str1,
such that every character of str2 appears in subStr in the same order as it is present in str2.

If there is no window in str1 that covers all characters in str2, return an empty string.
If there are multiple minimum-length windows, return the one with the leftmost starting index.

 */
public class MinSubsequence {
    public static String minWindow(String str1, String str2) {
        String result = null;
        var ind1 = 0;
        var ind2 = 0;
        while (ind1 < str1.length()) {
            if (str1.charAt(ind1) == str2.charAt(ind2)) {
                if (ind2 == str2.length() - 1) {
                    var start = ind1;
                    var end = ind1 + 1;
                    while (ind2 >= 0) {
                        if (str1.charAt(start) == str2.charAt(ind2)) {
                            ind2--;
                        }
                        start--;
                    }
                    start++;
                    if (result == null || end - start < result.length()){
                        result = str1.substring(start, end);
                    }
                    ind1 = start;
                    ind2 = 0;
                } else {
                    ind2++;
                }
            }
            ind1++;
        }

        return result == null ? "" : result;
    }
}
