package com.jimmimimmi.java.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/gray-code/
/*
89. Gray Code
Medium

589

1477

Add to List

Share
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        if (n < 0) return new ArrayList<>();

        if (n == 0) return new ArrayList<>() {{
            add(0);
        }};

        //0 = [0]
        //1 = [00, 01]
        //2 = [000, 010, 011, 001]
        //3 [000, 0100, 0110, 0010, 0011, 0111, 0101, 0001]

        ArrayList<String> result = new ArrayList<>();
        result.add("0");

        for (int i = 0; i <= n - 1; i++) {
            ArrayList<String> newResult = new ArrayList<>();
            result.forEach(s -> newResult.add(s + "0"));

            for (int j = result.size() - 1; j >= 0; j--) {
                newResult.add(result.get(j) + "1");
            }
            result = newResult;
        }

        return result.stream().map(s -> Integer.parseInt(s, 2)).collect(Collectors.toList());

    }
}
