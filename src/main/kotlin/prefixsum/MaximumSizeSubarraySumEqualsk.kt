package prefixsum

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
class MaximumSizeSubarraySumEqualsk {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        var runningSum = 0
        val valToIdx = HashMap<Int, Int>()
        valToIdx[0] = 0
        var best = 0
        for (i in 1..nums.size) {
            runningSum += nums[i - 1]

            val complement = runningSum - k
            if (valToIdx.containsKey(complement)) {
                best = kotlin.math.max(best, i - valToIdx[complement]!!)
            }
            if (!valToIdx.containsKey(runningSum)) {
                valToIdx[runningSum] = i
            }
        }

        return best
    }
}
