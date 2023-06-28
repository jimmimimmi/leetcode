package com.educative.grokking.exercises;

import java.util.Arrays;

public class VerifyinganAlienDictionary {
    public static boolean verifyAlienDictionary(String[] words, String order) {
        if (words.length <= 1) return true;
        var rank = new int[26];
        Arrays.fill(rank, -1);
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            var first = words[i];
            var second = words[i + 1];

            var j = 0;
            for (j = 0; j < first.length() && j < second.length(); j++) {
                var x = first.charAt(j);
                var y = second.charAt(j);
                var xRank = rank[x - 'a'];
                var yRank = rank[y - 'a'];

                if (xRank != yRank) {
                    if (xRank < yRank) {
                        break;
                    } else {
                        return false;
                    }
                }
            }

            if (j >= first.length() || j >= second.length()) {
                if (first.length() > second.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
