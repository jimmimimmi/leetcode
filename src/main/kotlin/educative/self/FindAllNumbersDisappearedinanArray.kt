package educative.self

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
class FindAllNumbersDisappearedinanArray {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (i in 0 until nums.size) {
            while (nums[i] != i + 1 && nums[i] <= nums.size && nums[i] != nums[nums[i] - 1]) {
                val correctIdx = nums[i] - 1
                val temp = nums[correctIdx]
                nums[correctIdx] = nums[i]
                nums[i] = temp
            }
        }

        return nums.mapIndexed { i, n ->
            (n - 1 != i) to i + 1
        }.filter { it.first }.map { it.second }
    }
}
