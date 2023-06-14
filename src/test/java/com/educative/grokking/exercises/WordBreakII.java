package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
You are given a string, s, and an array of strings, wordDict, representing a dictionary.
Your task is to add spaces to s to break it up into a sequence of valid words from wordDict.
We are required to return an array of all possible sequences of words (sentences).
The order in which the sentences are listed is not significant.
 */
public class WordBreakII {

    // abcde [a, ab, abc, bcde, de]
    public static List<String> wordBreakTabulation(String s, List<String> WordDict) {
        ArrayList<ArrayList<ArrayList<String>>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());
        for (int i = 1; i <= s.length(); i++) {
            dp.add(new ArrayList<>());
        }

        for (int i = 0; i <= s.length(); i++) {
            for (var word : WordDict) {
                if (s.substring(i).startsWith(word)) {
                    if (dp.get(i + word.length()) == null) {
                        dp.set(i + word.length(), new ArrayList<>());
                    }
                    dp.get(i + word.length()).addAll(
                            dp.get(i).stream().map(ar -> {
                                var newArr = new ArrayList<>(ar);
                                newArr.add(word);
                                return newArr;
                            }).collect(Collectors.toList()));
                }
            }
        }


        if (dp.get(s.length()) == null) return new ArrayList<>();
        return dp.get(s.length()).stream().map(ar -> String.join(" ", ar)).collect(Collectors.toList());

    }

    public static List<String> wordBreak(String s, List<String> WordDict) {
        var explore = explore(s, WordDict, new HashMap<>());
        if (explore == null) return new ArrayList<>();
        return explore;
    }

    private static ArrayList<String> explore(String s, List<String> wordDict, HashMap<String, ArrayList<String>> cache) {
        if (s.isEmpty()) {
            var empty = new ArrayList<String>();
            empty.add("");
            return empty;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        ArrayList<String> result = null;
        for (var word : wordDict) {
            if (s.startsWith(word)) {
                var res = explore(s.substring(word.length()), wordDict, cache);
                if (res != null) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    for (var subStr : res) {
                        if (!subStr.isEmpty())
                            result.add(word + " " + subStr);
                        else result.add(word);
                    }
                }
            }
        }

        cache.put(s, result);
        return result;
    }
}
