package educative.self

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
class LongestSubarrayOf1sAfterDeletingOneElement {

    fun longestSubarray(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }

        var left = 0
        var zeroCount = 0
        var result = 0

        for (right in 0 until nums.size) {
            if (nums[right] == 0) {
                zeroCount++
                while (zeroCount > 1) {
                    if (nums[left] == 0) {
                        zeroCount--
                    }
                    left++
                }
            }

            result = kotlin.math.max(result, right - left)
        }

        return result
    }

    fun longestSubarray1(nums: IntArray): Int {
        if (nums.size < 3) {
            return nums.size - 1
        }

        val totalSum = nums.sum()

        if (totalSum == nums.size) {
            return nums.size - 1
        }

        if (totalSum == 0) {
            return 0
        }

        val numStartsWihOne = nums.dropWhile { it == 0 }
        if (numStartsWihOne.isEmpty()) return 0

        var left = 0
        var right = 0

        var best = 0
        var windowFaced0 = false
        var windowRes = 0

        while (right < numStartsWihOne.size) {
            if (numStartsWihOne[right] == 1) {
                windowRes++
                if (numStartsWihOne[left] == 0) {
                    left = right
                }
            } else {
                if (!windowFaced0) {
                    windowFaced0 = true
                } else {
                    if (right > 0 && numStartsWihOne[right - 1] == 1) {
                        windowRes = right - left
                        windowFaced0 = true
                    } else {
                        windowRes = 0
                        windowFaced0 = false
                    }
                }
                left = right
            }

            best = kotlin.math.max(best, windowRes)
            right++
        }

        return best
    }
}
