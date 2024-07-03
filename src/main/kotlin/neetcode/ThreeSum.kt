package neetcode

// 15. 3Sum
// https://leetcode.com/problems/3sum/
class ThreeSum {
    fun twoSum(fixedIdx: Int, nums: IntArray): List<List<Int>> {
        if (nums.size - fixedIdx < 3) return emptyList()
        if (nums[fixedIdx] > 0) {
            return emptyList()
        }
        val target = 0 - nums[fixedIdx]

        val result = mutableListOf<List<Int>>()

        var left = fixedIdx + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum > target) {
                right--
            } else if (sum < target) {
                left++
            } else {
                result.add(listOf(nums[fixedIdx], nums[left], nums[right]))
                left++
                while (left < right && nums[left] == nums[left - 1]) {
                    left++
                }
            }
        }
        return result
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.sortedBy { it }.toIntArray()
        val result = mutableListOf<List<Int>>()
        for (i in nums.indices) {
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) {
                continue
            }

            val results = twoSum(i, sortedNums)
            result.addAll(results)
        }

        return result
    }
}