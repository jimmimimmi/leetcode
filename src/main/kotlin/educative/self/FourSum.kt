package educative.self

// https://leetcode.com/problems/4sum/description/
class FourSum {
    private fun twoSum(prevIdx: List<Int>, nums: IntArray, target: Long, res: ArrayList<List<Int>>) {
        val from = if (prevIdx.isNotEmpty()) prevIdx.last() + 1 else 0
        if (nums.size - from < 2) {
            return
        }

        var left = from
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[left].toLong() + nums[right].toLong()
            if (sum == target) {
                val ans = (prevIdx + listOf(left, right)).map { nums[it] }
                res.add(ans)
                left++
                while (left < right && nums[left] == nums[left - 1]) {
                    left++
                }
            } else if (sum < target) {
                left++
            } else {
                right--
            }
        }
    }

    private fun kSum(prevIdx: List<Int>, nums: IntArray, target: Long, res: ArrayList<List<Int>>, k: Int) {
        if (k == 2) {
            twoSum(prevIdx, nums, target, res)
        } else {
            val start = if (prevIdx.isEmpty()) 0 else prevIdx.last() + 1
            for (i in start until nums.size) {
                if (target > 0 && nums[i] > target) return
                if (i > start && nums[i] == nums[i - 1]) continue
                val subTarget = target - nums[i].toLong()
                kSum(prevIdx + i, nums, subTarget, res, k - 1)
            }
        }
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val sorted = nums.sortedArray()

        val result = ArrayList<List<Int>>()

        kSum(listOf(), sorted, target.toLong(), result, 4)

        return result
    }
}
