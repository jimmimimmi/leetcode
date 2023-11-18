package educative.self

class ThreeSum {
    private fun twoSum(first: Int, to: Int, nums: IntArray, target: Int, res: ArrayList<List<Int>>) {
        if (to - first < 2) return
        var left = first + 1
        var right = to
        while (left < right) {
            if (nums[left] > target) return
            val sum = nums[left] + nums[right]
            if (sum == target) {
                res.add(listOf(nums[first], nums[left], nums[right]))
                left++
                while (left < right && nums[left] == nums[left - 1]) {
                    left++
                }
            } else if (sum > target) {
                right--
            } else {
                left++
            }
        }
    }

    private fun threeSum(from: Int, to: Int, nums: IntArray, target: Int): List<List<Int>> {
        if (to - from + 1 < 3) return listOf()

        val res = ArrayList<List<Int>>()

        for (i in from..to) {
            if (nums[i] > target) return res
            if (i > 0 && nums[i] == nums[i - 1]) continue
            val subTarget = target - nums[i]
            val subRes = twoSum(i, to, nums, subTarget, res)
        }

        return res
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        return threeSum(0, nums.size - 1, nums.sortedArray(), 0)
    }
}
