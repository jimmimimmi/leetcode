package com.educative.grokking.exercises;

/*
You are required to find an integer t in an array arr of non-distinct integers. 
Prior to being passed as input to your search function, arr has been processed as follows:

It has been sorted in non-descending order.
It has been rotated around some pivot k, such that, after rotation, it looks like this: 
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]. 
For example, [10, 30, 40, 42, 42, 47, 78, 90, 901], 
rotated around pivot = 5 becomes [47, 78, 90, 901, 10, 30, 40, 42, 42].
Return TRUE if t exists in the rotated, sorted array arr, and FALSE otherwise, 
while minimizing the number of operations in the search.
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] arr, int t) {

        var left = 0;
        var right = arr.length - 1;
        while (left <= right) {
            if (left == right) return arr[left] == t;

            var mid = left + (right - left) / 2;
            if (arr[mid] == t) return true;

            if (arr[left] <= arr[mid]){ // left part is not rotated
                if (arr[left] <= t && t <= arr[mid]){ // t is in the left side
                    right = mid - 1;
                } else { // t is in the right side
                    left = mid + 1;
                }
            } else { // right part is not rotaed
                if (arr[mid] <= t && t <= arr[right]){ // t is in the left side
                    left = mid + 1;
                } else { // t is in the right side
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
