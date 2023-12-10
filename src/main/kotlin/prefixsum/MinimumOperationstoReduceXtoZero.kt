package prefixsum

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
class MinimumOperationstoReduceXtoZero {
    fun minOperations(nums: IntArray, x: Int): Int {
        /*
        [3,2,20,1,1,3], x = 10
        [3,5,25,26,27,30] - prefix sum
        [30,27,25,5,4,3] - suffix sum


        [1,1,4,2,3], x = 5
        [1,2,6,8,11]
        [11,10,9,5,3]

         */

        val sum = nums.sum()
        val target = (sum - x)
        if (target < 0) return -1

        var l = 0
        var runningSum = 0

        var bestDist = -1

        for (r in 0 until nums.size) {
            runningSum += nums[r]
            while (l <= r && runningSum > target) {
                runningSum -= nums[l]
                l++
            }
            if (runningSum == target) {
                bestDist = kotlin.math.max(bestDist, r - l + 1)
            }
        }

        if (bestDist == -1) return -1
        return nums.size - bestDist
    }
}
