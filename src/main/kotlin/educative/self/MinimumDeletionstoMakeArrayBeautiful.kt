package educative.self

// https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/description/
class MinimumDeletionstoMakeArrayBeautiful {
    fun minDeletion(nums: IntArray): Int {
        if (nums.size == 0) {
            return 0
        }

        if (nums.size == 1) {
            return 1
        }

        if (nums.size == 2) {
            return if (nums[0] == nums[1]) 2 else 0
        }

        var curIdx = 1
        var prevIdx = 0
        var size = nums.size
        var isOdd = true

        while (curIdx < nums.size) {
            // println("curIdx $curIdx = ${nums[curIdx]}, isOdd $isOdd, prevIdx $prevIdx = ${nums[prevIdx]}, size $size")
            if (isOdd) {
                if (nums[curIdx] == nums[prevIdx]) {
                    size--
                } else {
                    isOdd = false
                    prevIdx = curIdx
                }
            } else {
                isOdd = true
                prevIdx = curIdx
            }
            // println("\tcurIdx $curIdx = ${nums[curIdx]}, isOdd $isOdd, prevIdx $prevIdx = ${nums[prevIdx]}, size $size")
            curIdx++
        }

        if (size and 1 == 1) {
            size--
        }

        println("final size $size")
        return nums.size - size
    }
}
