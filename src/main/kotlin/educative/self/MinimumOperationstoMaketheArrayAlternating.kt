package educative.self

import java.util.*
import kotlin.math.min

// https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/description/
class MinimumOperationstoMaketheArrayAlternating {
    fun minimumOperations(nums: IntArray): Int {
        val evenOccurencies = HashMap<Int, Int>() // el -> freq
        val oddOccurencies = HashMap<Int, Int>() // el -> freq

        for (idx in 0 until nums.size) {
            if (idx and 1 == 1) {
                oddOccurencies[nums[idx]] = (oddOccurencies[nums[idx]] ?: 0) + 1
            } else {
                evenOccurencies[nums[idx]] = (evenOccurencies[nums[idx]] ?: 0) + 1
            }
        }

        val evenTop1 = intArrayOf(0, 0)
        val evenTop2 = intArrayOf(0, 0)

        val oddTop1 = intArrayOf(0, 0)
        val oddTop2 = intArrayOf(0, 0)

        evenOccurencies.forEach { num, freq ->
            if (freq > evenTop1[0]) {
                evenTop2[0] = evenTop1[0]
                evenTop2[1] = evenTop1[1]

                evenTop1[0] = freq
                evenTop1[1] = num
            } else if (freq > evenTop2[0]) {
                evenTop2[0] = freq
                evenTop2[1] = num
            }
        }

        oddOccurencies.forEach { num, freq ->
            if (freq > oddTop1[0]) {
                oddTop2[0] = oddTop1[0]
                oddTop2[1] = oddTop1[1]

                oddTop1[0] = freq
                oddTop1[1] = num
            } else if (freq > oddTop2[0]) {
                oddTop2[0] = freq
                oddTop2[1] = num
            }
        }

        if (evenTop1[1] != oddTop1[1]) {
            return nums.size - evenTop1[0] - oddTop1[0]
        }

        return min(
            nums.size - evenTop1[0] - oddTop2[0],
            nums.size - evenTop2[0] - oddTop1[0],
        )
    }
}
