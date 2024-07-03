package neetcode

// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class SearchinRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) {
            return if (nums[0] == target) 0 else -1
        }

        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val m = l + (r - l) / 2

            if (nums[m] == target) {
                return m
            }
            if (nums[m] >= nums[l]) {
                // we are in the left sorted part, no pivot here, pivot is after m
                if (target <= nums[m] && target >= nums[l]) {
                    r = m - 1
                } else {
                    l = m + 1
                }
            } else {
                // we are in the right sorted part, pivot is here, pivot is before m
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