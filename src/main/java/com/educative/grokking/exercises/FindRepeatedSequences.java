package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindRepeatedSequences {
    public static List<String> findRepeatedSequences(String s, int k) {

        var uniqueSequences = new HashSet<String>();
        var result = new HashSet<String>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            var substring = s.substring(i, i + k);
            if (uniqueSequences.contains(substring)) {
                result.add(substring);
            } else {
                uniqueSequences.add(substring);
            }
        }

        return new ArrayList<>(result);
    }

    private static long rollingHash(long prevHash, String s, int windowSize, int leftPointer) {
        int alphabetSize = 26;
        long maxCoef = (long) Math.pow(alphabetSize, windowSize);
        long hash = prevHash;
        if (leftPointer == 0) {
            for (int i = 0; i < windowSize; i++) {
                hash = hash * alphabetSize + (s.charAt(i) - 'a');
            }
        } else {
            hash = hash * alphabetSize;
            hash = hash - (s.charAt(leftPointer - 1) - 'a') * maxCoef;
            hash = hash + (s.charAt(leftPointer + windowSize - 1) - 'a');
        }
        return hash;
    }

    public static List<String> findRepeatedSequences_rollingHashing(String s, int k) {
        HashSet<Long> hashes = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        long hash = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            hash = rollingHash(hash, s, k, i);
            if (hashes.contains(hash)) {
                result.add(s.substring(i, i + k));
            } else {
                hashes.add(hash);
            }
        }
        return new ArrayList<>(result);

    }
}
