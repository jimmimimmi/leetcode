package com.educative.grokking.exercises;

import java.util.ArrayDeque;
import java.util.HashMap;

// https://leetcode.com/problems/next-greater-element-i/submissions/
public class NextGreaterElement {
    // [4,3,5]    [3,1,5,4,2,7]  => [7,5,7]
    /*
          Stack: 7,5,3
                7 => -1
                2 => 7
                4 => 7
                5 => 7
                1 => 5
                3 => 5

     */

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        var stack = new ArrayDeque<Integer>();
        var map = new HashMap<Integer, Integer>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            var curr = nums2[i];

            while (!stack.isEmpty() && stack.peekLast() < curr){
                stack.pollLast();
            }
            if (stack.isEmpty()){
                map.put(curr, -1);
            }else {
                map.put(curr, stack.peekLast());
            }

            stack.addLast(curr);
        }

        var res = new int[nums1.length];
        for (var i = 0; i< nums1.length; i++){
            var num = nums1[i];
            var ans = map.get(num);
            res[i] = ans == null ? -1 : ans;
        }


        return res;
    }
}
