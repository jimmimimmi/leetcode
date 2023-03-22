package com.educative.grokking.exercises;

import java.util.Arrays;

public class SumOfThree {
    /*
    Time complexity
Sorting the array: O(nLog(n)
Nested loop to find the triplet: O(n2)

The total time complexity of this solution is O(nlog(n)+n2)
 which can be simplified to O(n2)

Space complexity
In Java, the sorting algorithm takes O(log n)
to sort the input array. So, the space complexity of the above solution is O(logn)
.
     */
    public static boolean findSumOfThree(int[] nums, int target) {
        if (nums.length < 3) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = current + leftVal + rightVal;
                if (sum == target) return true;
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
