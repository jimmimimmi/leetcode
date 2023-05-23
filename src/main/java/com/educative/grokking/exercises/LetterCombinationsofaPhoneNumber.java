package com.educative.grokking.exercises;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        var dict = new HashMap<Character, List<Character>>();
        dict.put('1', List.of());
        dict.put('2', List.of('a', 'b', 'c'));
        dict.put('3', List.of('d', 'e', 'f'));
        dict.put('4', List.of('g', 'h', 'i'));
        dict.put('5', List.of('j', 'k', 'l'));
        dict.put('6', List.of('m', 'n', 'o'));
        dict.put('7', List.of('p', 'q', 'r', 's'));
        dict.put('8', List.of('t', 'u', 'v'));
        dict.put('9', List.of('w', 'x', 'y', 'z'));


        var result = new ArrayList<String>();
        recursive(dict, digits, 0, result);
        return result;
    }

    private static void recursive(HashMap<Character, List<Character>> dict, String digits, int currentIndex, ArrayList<String> result) {
        if (currentIndex == digits.length()) return;
        var digit = digits.charAt(currentIndex);
        var possibleChars = dict.get(digit);

        var newResult = new ArrayList<String>();
        if (result.isEmpty()) {
            for (Character c : possibleChars) {
                newResult.add(String.valueOf(c));
            }
        } else {
            for (Character c : possibleChars) {
                for (String s : result) {
                    String sb = s + c;
                    newResult.add(sb);
                }
            }
        }
        result.clear();
        result.addAll(newResult);
        recursive(dict, digits, currentIndex + 1, result);
    }

    public static List<String> letterCombinations2(String digits) {
        var dict = new HashMap<Character, List<Character>>();
        dict.put('1', List.of());
        dict.put('2', List.of('a', 'b', 'c'));
        dict.put('3', List.of('d', 'e', 'f'));
        dict.put('4', List.of('g', 'h', 'i'));
        dict.put('5', List.of('j', 'k', 'l'));
        dict.put('6', List.of('m', 'n', 'o'));
        dict.put('7', List.of('p', 'q', 'r', 's'));
        dict.put('8', List.of('t', 'u', 'v'));
        dict.put('9', List.of('w', 'x', 'y', 'z'));


        var result = new ArrayList<String>();
        recursive2(dict, digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void recursive2(
            HashMap<Character, List<Character>> dict,
            String digits,
            int currentIndex,
            StringBuilder currString,
            ArrayList<String> result) {
        if (currentIndex == digits.length()) {
            result.add(currString.toString());
            return;
        }

        var digit = digits.charAt(currentIndex);
        var possibleChars = dict.get(digit);

        for (Character c : possibleChars) {
            currString.append(c);
            recursive2(dict, digits, currentIndex + 1, currString, result);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}
