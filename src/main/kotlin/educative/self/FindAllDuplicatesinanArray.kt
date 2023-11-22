package educative.self

// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
class FindAllDuplicatesinanArray {
    fun findDuplicates(nums: IntArray): List<Int> {
        for (i in 0 until nums.size) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                val temp = nums[i]
                val tempIdx = nums[i] - 1
                nums[i] = nums[tempIdx]
                nums[tempIdx] = temp
            }
        }

        return nums.filterIndexed { i, n -> n != i + 1 }
    }
}
