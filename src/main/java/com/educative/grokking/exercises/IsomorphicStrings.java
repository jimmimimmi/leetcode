package com.educative.grokking.exercises;

import java.util.HashMap;

// https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicStrings {

    // aba, cdc => true   aba, ccd => false


    public static boolean isIsomorphic(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return true;
        }

        if (string2 == null) {
            return false;
        }

        if (string1 == null) {
            return false;
        }

        if (string1.length() != string2.length()) {
            return false;
        }
        var forward = new HashMap<Character, Character>();
        var backward = new HashMap<Character, Character>();

        for (int i = 0; i < string1.length(); i++) {
            var a = string1.charAt(i);
            var b = string2.charAt(i);

            var aToB = forward.get(a);
            var bToA = backward.get(b);

            if (aToB == null && bToA == null) {
                forward.put(a, b);
                backward.put(b, a);
            } else if(aToB == null || bToA == null) {
                return false;
            } else if (!aToB.equals(b) || !bToA.equals(a)) {
                return false;
            }
        }

        return true;
    }
}
