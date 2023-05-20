package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a sorted integer array nums and two integers—k and num—return
the k closest integers to num in this array.
Ensure that the result is sorted in ascending order.

The integer a is closer to num than an integer b if the following are true:

|a - num| < |b - num|, or
|a - num| == |b - num| and a < b

Intuition

We can actually find the bounds of our sliding window much faster - and independent of k!
First of all, what is the biggest index the left bound could be? If there needs to be k elements,
then the left bound's upper limit is arr.length - k, because if it were any further to the right,
you would run out of elements to include in the final answer.

As demonstrated in Approach 2,
binary search is typically used to find if an element exists or where an element belongs in a sorted array.
The beauty of algorithms lies in how abstract they are - with some clever thinking,
we can apply binary search in a unique way to move our left and right pointers closer and closer to the left bound of our answer.

Let's consider two indices at each binary search operation, the usual mid, and some index mid + k.
The relationship between these indices is significant because only one of them could possibly be in a final answer.
For example, if mid = 2, and k = 3, then arr[2] and arr[5] could not possibly both be in the answer,
since that would require taking 4 elements [arr[2], arr[3], arr[4], arr[5]].

This leads us to the question: how do we move our pointers left and right?
If the element at arr[mid] is closer to x than arr[mid + k],
then that means arr[mid + k], as well as every element to the right of it can never be in the answer.
This means we should move our right pointer to avoid considering them.
The logic is the same vice-versa - if arr[mid + k] is closer to x, then move the left pointer.


Assume we are taking A[i] ~ A[i + k -1].
We can binary research i
We compare the distance between x - A[mid] and A[mid + k] - x

@vincent_gui listed the following cases:
Assume A[mid] ~ A[mid + k] is sliding window

case 1: x - A[mid] < A[mid + k] - x, need to move window go left
-------x----A[mid]-----------------A[mid + k]----------

case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
-------A[mid]----x-----------------A[mid + k]----------

case 3: x - A[mid] > A[mid + k] - x, need to move window go right
-------A[mid]------------------x---A[mid + k]----------

case 4: x - A[mid] > A[mid + k] - x, need to move window go right
-------A[mid]---------------------A[mid + k]----x------

If x - A[mid] > A[mid + k] - x,
it means A[mid + 1] ~ A[mid + k] is better than A[mid] ~ A[mid + k - 1],
and we have mid smaller than the right i.
So assign left = mid + 1.

 */


public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] nums, int size, int target) {

        // https://leetcode.com/problems/find-k-closest-elements/solutions/106426/java-c-python-binary-search-o-log-n-k-k/
        if (nums.length < size) {
            return Arrays.stream(nums).boxed().collect(Collectors.toList());
        }
        var left = 0;
        var right = nums.length - size;
        while (left < right) {
            var mid = left + (right - left) / 2;
            if (target - nums[mid] > nums[mid + size] - target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Arrays.stream(nums, left, left  + size).boxed().collect(Collectors.toList());
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return mid;
            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}
