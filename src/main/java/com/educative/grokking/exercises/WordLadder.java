package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/DescriptionGiven/
public class WordLadder {

    private static int findDistance(String a, String b) {
        if (a.length() != b.length()){
            return Integer.MAX_VALUE;
        }
        var res = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public static int wordLadder(String src, String dest, List<String> words) {

        if (src.equals(dest)) {
            return 1;
        }

        var wordToIdxMap = new HashMap<String, Integer>();

        for (int i = 0; i < words.size(); i++) {
            wordToIdxMap.put(words.get(i), i);
        }

        var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{-1, 1});

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var head = queue.poll();
                var wordIdx = head[0];
                var wordStep = head[1];
                var word = wordIdx == -1 ? src : words.get(wordIdx);

                if (word.equals(dest)) {
                    return wordStep;
                }


                var entries = new HashSet<>(wordToIdxMap.entrySet());
                for (var entry : entries) {
                    var nextWord = entry.getKey();
                    if (findDistance(word, nextWord) == 1) {
                        queue.add(new int[]{entry.getValue(), wordStep + 1});
                        wordToIdxMap.remove(nextWord);
                    }
                }
            }
        }


        // Replace this placeholder return statement with your code
        return 0;
    }
}
