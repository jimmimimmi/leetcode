package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
public class LongestPalindromebyConcatenatingTwoLetterWords {

    /*
        xx => group and count the length within each group
        use all elements form the longest group =>    [size of group * 2]

        xy => need to find reversed elements and count them consequently
        need to use minimum



         group separately one letter elements
         group separately two letters elements
         group and count all occurrencies

         group1: find the most frequent odd occurrence and use them all
         group1: reduce all other to even occurrence and use them

         group2: for each element need its mirrored sibling and take min occurrence

         "aa", "xx", "ad", "cc", "xx", "xx", "cc", "cc", "xx", "aa", "ba"

         aa, aa
         xx, xx, xx, xx
         ad
         cc, cc, cc,
         ba

     */
    public static int longestPalindrome(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }
        var sameLetterFreq = new HashMap<String, Integer>();
        for (var word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                sameLetterFreq.put(word, sameLetterFreq.getOrDefault(word, 0) + 1);
            }
        }

        String mostFreqOddSameLetterWord = null;
        var topFreqOddForSameLetterWord = 0;

        for (var entry : sameLetterFreq.entrySet()) {
            var word = entry.getKey();
            var freq = entry.getValue();
            if (freq % 2 == 1 && freq > topFreqOddForSameLetterWord) {
                topFreqOddForSameLetterWord = freq;
                mostFreqOddSameLetterWord = word;
            }
        }


        int res = 0;
        if (mostFreqOddSameLetterWord != null) {
            res += topFreqOddForSameLetterWord * 2;
        }

        for (var entry : sameLetterFreq.entrySet()) {
            if (entry.getKey().equals(mostFreqOddSameLetterWord)) {
                continue;
            }
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue() * 2;
            } else {
                res += (entry.getValue() - 1) * 2;
            }
        }

        var twoLetterFreq = new HashMap<String, Integer>();
        for (var word : words) {
            if (word.charAt(0) != word.charAt(1)) {
                twoLetterFreq.put(word, twoLetterFreq.getOrDefault(word, 0) + 1);
            }
        }

        var visited = new HashSet<String>();

        for (var entry : twoLetterFreq.entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }

            var word = entry.getKey();
            var wordFreq = entry.getValue();

            var brotherWord = new String(new char[]{word.charAt(1), word.charAt(0)});
            var brotherFreq = twoLetterFreq.get(brotherWord);
            if (brotherFreq != null) {
                var minFreq = (brotherFreq < wordFreq ? brotherFreq : wordFreq);
                res += minFreq * 4;
            }

            visited.add(word);
            visited.add(brotherWord);
        }


        return res;
    }
}
