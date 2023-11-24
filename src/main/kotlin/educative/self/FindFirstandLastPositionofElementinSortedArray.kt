package educative.self

import java.util.*

class FindFirstandLastPositionofElementinSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val rightResul = rightIdOfTarget(nums, target)
        val leftResul = leftIdOfTarget(nums, target)

        return intArrayOf(leftResul, rightResul)
    }

    private fun leftIdOfTarget(nums: IntArray, target: Int): Int {
        var l = -1
        var r = nums.size

        while (r - l > 1) {
            val m = l + (r - l) / 2
            if (nums[m] < target) {
                l = m
            } else {
                r = m
            }
        }

        return if (l < nums.size - 1 && nums[l + 1] == target) l + 1 else -1
    }

    private fun rightIdOfTarget(nums: IntArray, target: Int): Int {
        var l = -1
        var r = nums.size

        while (r - l > 1) {
            val m = l + (r - l) / 2
            if (nums[m] > target) {
                r = m
            } else {
                l = m
            }
        }

        return if (r > 0 && nums[r - 1] == target) r - 1 else -1
    }
}
