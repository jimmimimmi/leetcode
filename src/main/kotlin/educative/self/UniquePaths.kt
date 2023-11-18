package educative.self

// https://leetcode.com/problems/unique-paths/description/
class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array<IntArray>(m) { IntArray(n) { 0 } }
        dp[0][0] = 1


        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == j && i == 0) {
                    continue
                }
                val leftSum = if (j > 0) dp[i][j - 1] else 0
                val topSum = if (i > 0) dp[i - 1][j] else 0
                dp[i][j] = leftSum + topSum
            }
        }

        return dp[m - 1][n - 1]
    }
}
