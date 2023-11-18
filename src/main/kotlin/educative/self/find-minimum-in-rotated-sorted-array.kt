package educative.self

import kotlin.math.min

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
class `find-minimum-in-rotated-sorted-array` {
    fun findMin(nums: IntArray): Int {
        if (nums[0] < nums[nums.size - 1] || nums.size == 1) {
            return nums[0]
        }

        if (nums.size == 2) {
            return min(nums[0], nums[1])
        }

        var left = 0
        var right = nums.size - 1
        // 1,2,3,  4   ,5,6,7,0
        while (left < right) {
            val pivot = left + (right - left) / 2
            if (
                nums[(pivot - 1) % nums.size] < nums[pivot % nums.size] &&
                nums[pivot % nums.size] > nums[(pivot + 1) % nums.size]
            ) {
                return nums[(pivot + 1) % nums.size]
            }

            if (
                nums[(pivot - 1) % nums.size] > nums[pivot % nums.size] &&
                nums[pivot % nums.size] < nums[(pivot + 1) % nums.size]
            ) {
                return nums[pivot % nums.size]
            }

            if (nums[0] < nums[pivot]) {
                left = pivot
            } else {
                right = pivot
            }
        }

        return 0
    }
}
