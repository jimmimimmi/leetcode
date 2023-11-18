package educative.self

import kotlin.math.*

// https://leetcode.com/problems/maximum-subarray/description/
class MaximumSubArray {
    // -2,1,-3,4,-1,2,1,-5,4
    // -2,3,1,3
    fun maxSubArray(nums: IntArray): Int {
        var result = nums[0]
        var currentMax = nums[0]
        if (nums.size == 1) {
            return result
        }

        for (i in 1 until nums.size) {
            val nextSum = currentMax + nums[i]
            if (nextSum > 0) {
                currentMax = nextSum
                result = max(result, currentMax)
            } else {
                currentMax = max(0, nums[i])
                result = max(result, nums[i])
            }
        }

        return result
    }
}
