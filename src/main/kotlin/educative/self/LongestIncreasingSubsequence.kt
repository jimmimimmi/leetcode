package educative.self

import java.util.*
import kotlin.math.max

// https://leetcode.com/problems/longest-increasing-subsequence/description/
class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val tree = TreeMap<Int, Int>()
        val lengthToMin = HashMap<Int, Int>()
        var res = 0
        nums.forEach {
            val floor = tree.floorEntry(it)
            if (floor?.key != it) {
                val itLength = (floor?.value ?: 0) + 1
                tree[it] = itLength
                res = max(res, itLength)

                val prevNumWithSameLength = lengthToMin[itLength]
                if (prevNumWithSameLength != null) {
                    if (prevNumWithSameLength > it) {
                        tree.remove(prevNumWithSameLength)
                        lengthToMin[itLength] = it
                    } else {
                        tree.remove(itLength)
                    }
                } else {
                    lengthToMin[itLength] = it
                }
            }
        }
        return res
    }
}
