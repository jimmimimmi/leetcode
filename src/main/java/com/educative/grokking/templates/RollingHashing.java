package com.educative.grokking.templates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RollingHashing {
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
