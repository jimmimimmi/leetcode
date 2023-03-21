package com.jimmimimmi.java.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

//https://leetcode.com/problems/next-greater-element-i/
/*
496. Next Greater Element I
Easy

1393

1945

Add to List

Share
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.

[5, 2 , 3] [10, 20, 30, 40, 5, 11, 6, 7, 12]

 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        var numberAndGreaterMap = new HashMap<Integer, Integer>();
        var descendingNums = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!descendingNums.isEmpty() && nums[i] > descendingNums.getLast()) {
                var former = descendingNums.removeLast();
                numberAndGreaterMap.put(former, nums[i]);
            }
            descendingNums.addLast(nums[i]);
        }

        while (!descendingNums.isEmpty()) {
            numberAndGreaterMap.put(descendingNums.removeLast(), -1);
        }

        var result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = numberAndGreaterMap.get(findNums[i]);
        }

        return result;
    }
}
