package com.jimmimimmi.java.recursion;

//https://leetcode.com/problems/decode-string/
/*
394. Decode String
Medium

2766

139

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    private int getCloseBracket(String s, int openBracket) {
        int openCount = 1;
        for (int i = openBracket + 1; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                openCount--;
                if (openCount == 0) return i;
            } else if (s.charAt(i) == '[') {
                openCount++;
            }
        }
        return -1;
    }

    private String extractNTimes(String s, int n, int start, int end) {
        var substring = decodeString(s, start, end);
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(substring);
        }
        return sb.toString();
    }

    private String decodeString(String s, int start, int end) {
        var current = start;
        StringBuilder result = new StringBuilder();
        while (current < end) {
            if (s.charAt(current) == '[') {
                var closeBracket = getCloseBracket(s, current);
                var timesSb = new StringBuilder();
                var integerIdx = current - 1;
                while (integerIdx >= 0 && s.charAt(integerIdx) >= '0' && s.charAt(integerIdx) <= '9') {
                    timesSb.insert(0, s.charAt(integerIdx));
                    integerIdx--;
                }
                var times = Integer.parseInt(timesSb.toString());
                var subResult = extractNTimes(s, times, current + 1, closeBracket);
                result.append(subResult);
                current = closeBracket + 1;
            } else if (s.charAt(current) >= '0' && s.charAt(current) <= '9') current++;
            else {
                result.append(s.charAt(current));
                current++;
            }
        }
        return result.toString();
    }

    public String decodeString(String s) {
        return decodeString(s, 0, s.length());
    }
}
