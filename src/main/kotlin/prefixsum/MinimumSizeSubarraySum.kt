package prefixsum

import java.util.*

// https://leetcode.com/problems/minimum-size-subarray-sum/
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        val sumToIdx = TreeMap<Int, Int>()
        sumToIdx[0] = -1

        var res = nums.size + 1

        // [2,3,1,2,4,3]  7
        for (i in 0 until nums.size) {
            sum += nums[i]
            val complement = sum - target
            val complementIdx = sumToIdx.floorEntry(complement)
            if (complementIdx != null) {
                res = kotlin.math.min(res, i - complementIdx.value)
            }
            sumToIdx[sum] = i
            // println("i $i, sum $sum, complement $complement, complementIdx $complementIdx, res $res, map $sumToIdx ")
        }

        if (res == nums.size + 1) {
            return 0
        }

        return res
    }
}
