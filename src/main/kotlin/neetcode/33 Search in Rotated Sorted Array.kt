package neetcode

// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class `33 Search in Rotated Sorted Array` {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) {
            return if (nums[0] == target) 0 else -1
        }

        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            var m = l + (r - l) / 2
            if (nums[m] == target) {
                return m
            }
            if (nums[m] >= nums[l]) {
                if (target <= nums[m] && target >= nums[l]) {
                    r = m - 1
                } else {
                    l = m + 1
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1
                } else {
                    r = m - 1
                }
            }
        }

        return -1;
    }
}