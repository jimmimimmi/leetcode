package com.leetcode;

/*
10 Рим - 14 Барселона. 720 евро

8го Ларнака - Рим 750 евро
15го Рим - Ларнака
15го Барселона Рим 150
Чемодан 100

1 ночь в Барселоне
2 ночи в Риме

1720



 */

/*
763. Partition Labels
Medium
9.3K
344
company
Amazon
company
Facebook
company
Uber
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.



Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 */

/*
a -> 0, 2, 6, 8
b -> 1, 3, 5, 9
c -> 4, 7, 10

ababcbacabc efegde hijhklij
l       r
         r
          r




start from the first char and moving from the end backwards looking for the same symbol
IF it is NOT FOUND we move that symbol into a partition then move one step right and repeat
ELSE we need to explore an interval [left, right] (where s[left] == s[right] currently)
for the case if another chars within [left, right] they also are presented in another part of s [right+1, n-1]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N763_Partition_Labels {
    public static List<Integer> partitionLabels(String s) {

        var charToMaxPositions = new HashMap<Character, Integer>();
        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charToMaxPositions.put(chars[i], i);
        }
        var result = new ArrayList<Integer>();

        var left = 0;

        while (left < chars.length) {
            if (charToMaxPositions.get(chars[left]) == left) {
                result.add(1);
                left++;
                continue;
            }

            var right = charToMaxPositions.get(chars[left]); //8
            var mid = left;//0
            while (mid <= right) {
                right = Math.max(right, charToMaxPositions.get(chars[mid]));
                mid++;
            }
            result.add(right - left + 1);
            left = right + 1;
        }
        return result;
    }
}
