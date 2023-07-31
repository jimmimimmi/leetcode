package com.educative.grokking.exercises;

/*

https://leetcode.com/problems/find-the-duplicate-number/description/
Given an unsorted array of positive numbers, nums, such that the values lie in the range
[1,n], inclusive, and that there are n+1
 numbers in the array, find and return the duplicate number present in nums.
 There is only one repeated number in nums.
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {

        var slow = 0;
        var fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
