package com.educative.grokking.exercises;

import com.educative.grokking.templates.Api;

/*
The latest version of a software product fails the quality check.
Since each version is developed upon the previous one,
all the versions created after a bad version are also considered bad.

Suppose you have n  versions with the IDs [1,2,...,n],
and you have access to an API function that returns TRUE if the argument is the ID of a bad version.

Your task is to find the first bad version,
which is causing all the later ones to be bad.
You have to implement a solution with the minimum number of API calls.
 */
public class FirstBadVersion {
    static Api versionApi = new Api();

    public static boolean isBadVersion(int v) {
        return versionApi.isBad(v);
    }

    // f, f, f, f, t
    public static int[] firstBadVersion(int n) {
        // -- DO NOT CHANGE THIS SECTION
        versionApi.n = n;
        // --

        var counter = 0;
        var left = 1;
        var right = n;
        while (left < right) {
            var mid = left + (right - left) / 2;
            var isMidBad = isBadVersion(mid);
            counter++;
            if (isMidBad) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Write your code here
        return new int[]{left, counter};
    }
}
