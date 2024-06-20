package twopointers

import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/container-with-most-water/description/
class MaxArea {
    fun maxArea(height: IntArray): Int {
        val decreasing = ArrayDeque<Int>()

        var result = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            var rect = (right - left) * min(height[left], height[right])
            result = max(result, rect)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return result
    }
}
