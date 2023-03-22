package com.educative.grokking.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReverseWords {
    private static char[] reverse(char[] chars, int l, int r) {
        if (chars == null || r <= l) return chars;
        int left = l;
        int right = r;

        while (left < right) {
            char lChar = chars[left];
            char rChar = chars[right];

            chars[left] = rChar;
            chars[right] = lChar;
            left++;
            right--;
        }
        return chars;
    }

    public static String reverseWords(String sentence) throws JsonProcessingException {
        if (sentence == null || sentence.length() < 2) return sentence;
        System.out.println("origi sentence:" + new ObjectMapper().writeValueAsString(sentence));

        char[] reversedSentence = reverse(sentence.toCharArray(), 0, sentence.length() - 1);

        System.out.println("reversed sentence:" + new ObjectMapper().writeValueAsString(reversedSentence));
        int left = 0;
        int right = 1;

        while (right < reversedSentence.length) {
            while (right < reversedSentence.length && reversedSentence[right] != ' ') {
                right++;
            }

            while (left < reversedSentence.length && reversedSentence[left] == ' ') {
                left++;
            }

            if (left == reversedSentence.length) break;

            reverse(reversedSentence, left, right - 1);

            left = right;
            right++;
        }

        return new String(reversedSentence);
    }
}
