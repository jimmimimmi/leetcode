package com.educative.grokking.exercises;

public class IsPalindrom {
    static boolean isPalindrom(char[] s, int l, int r) {
        int left = l;
        int right = r;
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }

    static boolean isPalindrom(String s) {
        return isPalindrom(s.toCharArray(), 0, s.length());
    }

    static boolean isPalindromIfOneElementCanBeRemoved(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                boolean isP1 = isPalindrom(chars, left, right - 1);
                if (isP1) return isP1;
                return isPalindrom(chars, left + 1, right);
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}
