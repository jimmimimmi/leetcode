package com.educative.grokking.exercises;

import java.util.ArrayList;

public class Permutations {
    public static ArrayList<String> permuteWord(String word) {

        // Your code will replace this placeholder return statement

        var result = new ArrayList<String>();
        buildPermutation(word, 0, result);
        return result;
    }

    // a b c
    private static void buildPermutation(String word, int currIndex, ArrayList<String> result) {
        if (currIndex == word.length() - 1){
            result.add(word);
            return;
        }

        for (int i = currIndex; i < word.length(); i++) {
            var chars = word.toCharArray();
            var temp = chars[i];
            chars[i] = chars[currIndex];
            chars[currIndex] = temp;
            var swappedWord = String.valueOf(chars);
            buildPermutation(swappedWord, currIndex + 1, result);
        }
    }


}
