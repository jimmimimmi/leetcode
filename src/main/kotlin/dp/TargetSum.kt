package dp

// https://leetcode.com/problems/target-sum/description/
class TargetSum {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val sum = nums.sum()
        if (target > sum || target < -sum) return 0
        val dp = HashMap<Pair<Int, Int>, Int>()
        var res = 0
        for (j in -sum..sum) {
            if (j == nums[0] || j == -nums[0]) {
                dp[0 to j] = if (j == 0) 2 else 1
            } else {
                dp[0 to j] = 0
            }
        }

        for (i in 1 until nums.size) {
            for (j in -sum..sum) {
                val prev1 = j - nums[i]
                val prev2 = j + nums[i]
                dp[i to j] = (dp[i - 1 to prev2] ?: 0) + (dp[i - 1 to prev1] ?: 0)
            }
        }

        return dp[(nums.size - 1) to (target)] ?: 0
    }
}
