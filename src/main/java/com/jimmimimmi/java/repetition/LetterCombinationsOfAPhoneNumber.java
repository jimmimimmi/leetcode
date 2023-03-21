package com.jimmimimmi.java.repetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        var numberToLetters = new String[][]{
                new String[]{"a", "b", "c"}, //2
                new String[]{"d", "e", "f"}, //3
                new String[]{"g", "h", "i"}, //4
                new String[]{"j", "k", "l"}, //5
                new String[]{"m", "n", "o"}, //6
                new String[]{"p", "q", "r", "s"}, //7
                new String[]{"t", "u", "v"}, //8
                new String[]{"w", "x", "y", "z"}, //9
        };

        var result = new ArrayList<String>();
        explore(digits, 0, "", numberToLetters, result);
        return result;
    }

    private void explore(String digits, int currentIdx, String currentResult, String[][] numberToLetters, List<String> result) {
        if (currentResult.length() == digits.length()) {
            result.add(currentResult);
            return;
        }

        var currentDigitOffset = digits.charAt(currentIdx) - '2';
        var lettersForCurrentDigit = numberToLetters[currentDigitOffset];

        for (String letter : lettersForCurrentDigit) {
            explore(digits, currentIdx + 1, currentResult + letter, numberToLetters, result);
        }
    }
}
