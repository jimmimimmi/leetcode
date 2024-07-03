package neetcode

import kotlin.math.max

// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/description/
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()

        var result = 0
        set.forEach { cur ->
            if (!set.contains(cur - 1)) {
                var curResult = 0
                var curElement = cur
                while(set.contains(curElement)){
                    curResult++
                    curElement++
                }

                result = max(result, curResult)

            }
        }

        return result
    }
}