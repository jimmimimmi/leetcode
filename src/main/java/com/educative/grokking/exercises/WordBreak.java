package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        return explore(0, new ArrayList<>(), new HashMap<>(), s, wordDict);
    }

    public static boolean explore(int startIdx, List<String> path, HashMap<Integer, Boolean> cache, String s, List<String> wordDict) {
        if (startIdx >= s.length()) {
            return true;
        }
        if (cache.containsKey(startIdx)) {
            return cache.get(startIdx);
        }

        for (var word : wordDict) {
            var endIndex = startIdx + word.length();
            if (endIndex > s.length()) {
                continue;
            }
            if (s.substring(startIdx, endIndex).equals(word)) {
                path.add(word);
                var res = explore(endIndex, path, cache, s, wordDict);
                if (res) {
                    cache.put(startIdx, true);
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }

        cache.put(startIdx, false);
        return false;
    }


    // highway   ["crash", "cream", "high", "low", "away"]
    public static boolean wordBreakDp(String s, List<String> wordDict) {
        // 0,0,0,0,0,0,0,0
        var dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 1,0,0,0,0,0,0,0

        for (int i = 1; i <= s.length(); i++) {
            for (var word : wordDict) {
                if (i - word.length() < 0) {
                    continue;
                }
                if (dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
