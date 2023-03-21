package com.jimmimimmi.java.recursion;

import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.*;

//https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2905/
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

 */

public class LetterCombinationsOfAPhoneNumber {

    private String[] getRespectedLetters(char c) {
        if (c == '1') return new String[0];
        if (c == '2') return new String[]{"a", "b", "c"};
        if (c == '3') return new String[]{"d", "e", "f"};
        if (c == '4') return new String[]{"g", "h", "i"};
        if (c == '5') return new String[]{"j", "k", "l"};
        if (c == '6') return new String[]{"m", "n", "o"};
        if (c == '7') return new String[]{"p", "q", "r", "s"};
        if (c == '8') return new String[]{"t", "u", "v"};
        if (c == '9') return new String[]{"w", "x", "y", "z"};
        throw new NoSuchElementException("non supported symbol " + c);
    }

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return result;
        return explore(0, digits);
    }

    private List<String> explore(int currentIdx, String digits) {

        var respectedLetters = getRespectedLetters(digits.charAt(currentIdx));
        if (currentIdx == digits.length() - 1) {
            return Arrays.stream(respectedLetters).collect(Collectors.toList());
        }
        ArrayList<String> result = new ArrayList<>();
        for (String l : respectedLetters) {
            var subResult = explore(currentIdx + 1, digits);
            for (String subString : subResult
            ) {
                result.add(l + subString);
            }
        }
        return result;
    }
}
