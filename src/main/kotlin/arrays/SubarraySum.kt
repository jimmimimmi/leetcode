package arrays

// https://leetcode.com/problems/subarray-sum-equals-k/description/
class SubarraySum {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSums = IntArray(nums.size) { 0 }
        prefixSums[0] = nums[0]
        for (i in 1 until nums.size) {
            prefixSums[i] = prefixSums[i - 1] + nums[i]
        }

        val prefixSumFrequencies = HashMap<Int, Int>()
        prefixSumFrequencies[0] = 1
        var res = 0
        prefixSums.forEach {
            val expectedPrefixSum = it - k
            res += (prefixSumFrequencies[expectedPrefixSum] ?: 0)

            prefixSumFrequencies[it] = (prefixSumFrequencies[it] ?: 0) + 1
        }

        return res
    }
}
