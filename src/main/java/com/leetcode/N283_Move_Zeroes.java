package com.leetcode;


/*
283. Move Zeroes
Easy
13.1K
330
company
Yandex
company
Amazon
company
Facebook
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Самолет Пафос-Париж, 13 апреля (Чт), 6 утра, 200 евро
250 евро отель В Париже
300 евро в Париже на еду развлечения
автобусы в аэропорт и обратно 100 евро

Самолет Париж-Генуя 14 апреля (Пт), 10:45 утра, 200 евро
130 евро отель В Генуе
150 евро в Генуэ на еду развлечения
Транспорт в генуж 50 евро

15 Апреля - 20 Апреля. Круиз Генуя - Валенсия. 1000 евро, 400 евро экскурсии, 300 евро траты по городу

20 Апреля Валенсия отель 80 евро
21 Апреля Валенсия - Мальта

 */
public class N283_Move_Zeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        var left = 0;
        while (true) {
            while (left < nums.length - 1 && nums[left] != 0) {
                left++;
            }
            if (left == nums.length - 1) return;
            // left is pointing to 0
            var right = left + 1;

            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (right == nums.length) return;

            // right is pointing to non-0
            nums[left] = nums[right];
            nums[right] = 0;
        }

    }
}
