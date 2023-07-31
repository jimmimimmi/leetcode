package com.educative.grokking.exercises;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    // "aaacbbbaabab", 2
    // a => {a:1} => 1
    // aa => {a:2} => 2
    // aaa => {a:3} => 3
    // aaac => {a:3, c:1} => 4
    // aaacb => {a:3, c:1, b:1} => 5
    // acbb => {a:1, c:1, b:2} => 4
    // acbbb => {a:1, c:1, b:3} => 5
    // cbbba => {a:1, c:1, b:3} => 5
    // bbbaa => {a:2, b:3} => 5
    // bbbaab => {a:2, b:4} => 6
    // baaba => {a:3, b:2} => 5
    // baabab => {a:3, b:3} => 5


    // "dippitydip", 4
    // d => {d:1} =>1
    // di => {d:1, i:1} =>2
    // dipp => {d:1, i:1, p:2} => 4
    // dippit => {d:1, i:2, p:2, t:1} => 6
    // ippity => {i:2, p:2, t:1, y:1} => 6
    // ppityd => {d:1, i:1, p:2, t:1, y:1} => 6
    // pitydip => {d:1, i:2, p:2, t:1, y:1} => 6


    // "coollooc", 2
    // c => {c:1} => 1
    // co => {c:1, o:1} => 2
    // coo => {c:1, o:2} => 3
    // cool => {c:1, o:2, l:1} => 4
    // ooll => { o:2, l:2} => 4
    // oollo => { o:3, l:2} => 5
    // oolloo => { o:4, l:2} => 5
    // looc => { o:4, l:2} => 6


    public static int longestRepeatingCharacterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() <= k) return s.length();

        var left = 0;
        var right = 0;

        var chatFreq = new HashMap<Character, Integer>();
        var freqChars = new TreeMap<Integer, HashSet<Character>>(Comparator.reverseOrder());
        var result = 0;

        while (right < s.length()) {
            var currChar = s.charAt(right);
            var prevFreq = chatFreq.getOrDefault(currChar, 0);
            var newFreq = prevFreq + 1;
            chatFreq.put(currChar, newFreq);
            if (freqChars.containsKey(prevFreq)) {
                freqChars.get(prevFreq).remove(currChar);
            }
            if (!freqChars.containsKey(newFreq)) {
                freqChars.put(newFreq, new HashSet<>());
            }
            freqChars.get(newFreq).add(currChar);


            if (right - left + 1 - freqChars.firstKey() > k) {
                var leftChar = s.charAt(left);
                var prevFreqLeft = chatFreq.get(leftChar);
                var newFreqLeft = prevFreqLeft - 1;
                chatFreq.put(leftChar, newFreqLeft);

                if (freqChars.containsKey(prevFreqLeft)) {
                    freqChars.get(prevFreqLeft).remove(leftChar);
                }
                if (!freqChars.containsKey(newFreqLeft)) {
                    freqChars.put(newFreqLeft, new HashSet<>());
                }
                freqChars.get(newFreqLeft).add(leftChar);
                left++;
            }

            result = Math.max(result, right - left + 1);

            right++;

        }

        return result;
    }
}
