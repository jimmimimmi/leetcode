package dp

// https://leetcode.com/problems/partition-equal-subset-sum/
class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum and 1 == 1) return false
        val target = sum / 2

        val dp = Array<BooleanArray>(nums.size + 1) { BooleanArray(target + 1) }
        dp[0][0] = true
        for (i in 1..nums.size) {
            val currEl = nums[i - 1]
            for (j in 0..target) {
                if (currEl == j) {
                    dp[i][j] = true
                } else if (dp[(i - 1)][j]) {
                    dp[i][j] = true
                } else if (currEl < j) {
                    dp[i][j] = dp[(i - 1)][(j - currEl)]
                } else {
                    dp[i][j] = false
                }
            }
        }

        return dp[(nums.size - 1)][target]
    }
}
