package educative.self

class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.size <= 1) {
            return false
        }
        val numToIdx = HashMap<Int, Int>()
        for (i in 0 until nums.size) {
            val cur = nums[i]
            val prevIdx = numToIdx[cur]
            if (prevIdx != null) {
                if (i - prevIdx <= k) {
                    return true
                }
            }
            numToIdx[cur] = i
        }

        return false
    }
}
