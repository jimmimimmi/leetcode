package prefixsum

// https://leetcode.com/problems/contiguous-array/
class ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        val prefixSums = HashMap<Int, Int>()
        prefixSums[0] = 0
        var res = 0

        var runningSum = 0
        for (i in 1..nums.size) {
            val num = nums[i - 1]
            if (num == 0) {
                runningSum++
            } else {
                runningSum--
            }

            val prev = prefixSums[runningSum]
            if (prev != null) {
                res = kotlin.math.max(res, i - prev)
            } else {
                prefixSums[runningSum] = i
            }
        }

        return res
    }
}
