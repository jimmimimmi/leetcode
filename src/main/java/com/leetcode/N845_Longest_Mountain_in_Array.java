package com.leetcode;

/*
845. Longest Mountain in Array
Medium
2.4K
67
company
Bloomberg
company
Microsoft
company
Google
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.



Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.


Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104


Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
 */

public class N845_Longest_Mountain_in_Array {
    // 1. find the point L we start climbing from
    // 2. start climbing (arr[L] < arr[L+1] and increase the temp length
    // 3. if a plato is found repeat with step 1.
    // 4. if a peak is found start going down and increase the temp length
    // 5. if a plato or increasing is found save temp length into max_length
    public static int longestMountain(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        int left = 0;
        int maxLength = 0;
        while (true) {
            while (left < arr.length - 2 && arr[left] >= arr[left + 1]) {
                left++;
            }
            if (left >= arr.length - 2) break;

            var isClimbing = true;
            var currentLength = 1;
            while (left < arr.length - 1) {
                if (isClimbing && arr[left] < arr[left + 1]) {
                    currentLength++;
                    left++;
                } else if (isClimbing && arr[left] > arr[left + 1]) {
                    isClimbing = false;
                    currentLength++;
                    left++;
                    maxLength = Math.max(maxLength, currentLength);
                } else if (!isClimbing && arr[left] > arr[left + 1]) {
                    currentLength++;
                    left++;
                    maxLength = Math.max(maxLength, currentLength);
                } else if (!isClimbing) {
                    break;
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }
}
