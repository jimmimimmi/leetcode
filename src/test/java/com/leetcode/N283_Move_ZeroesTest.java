package com.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

public class N283_Move_ZeroesTest extends TestCase {

    public void testMoveZeroes() throws JsonProcessingException {
        var nums1 = new int[]{0, 1, 0, 2, 3};
        var nums2 = new int[]{0, 0, 1, 0, 2, 3, 0};
        var nums3 = new int[]{0, 0, 1, 0, 0, 0, 3};
        var nums4 = new int[]{1, 0, 0};
        var nums5 = new int[]{1};
        var nums6 = new int[]{0};
        N283_Move_Zeroes.moveZeroes(nums1);
        N283_Move_Zeroes.moveZeroes(nums2);
        N283_Move_Zeroes.moveZeroes(nums3);
        N283_Move_Zeroes.moveZeroes(nums4);
        N283_Move_Zeroes.moveZeroes(nums5);
        N283_Move_Zeroes.moveZeroes(nums6);

        System.out.println(new ObjectMapper().writeValueAsString(nums1));
        System.out.println(new ObjectMapper().writeValueAsString(nums2));
        System.out.println(new ObjectMapper().writeValueAsString(nums3));
        System.out.println(new ObjectMapper().writeValueAsString(nums4));
        System.out.println(new ObjectMapper().writeValueAsString(nums5));
        System.out.println(new ObjectMapper().writeValueAsString(nums6));
    }
}