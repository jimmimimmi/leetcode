package educative.self

import java.util.*
import kotlin.math.*

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
class LargestRectangleinHistogram {
    fun largestRectangleArea(heights: IntArray): Int {
        val increasingHeightsStack = Stack<Int>()
        val widthStack = Stack<Int>()

        var maxRect = 0

        increasingHeightsStack.push(0)
        widthStack.push(0)

        for (i in 1..heights.size) {
            val h = heights[i - 1]
            if (increasingHeightsStack.peek() <= h) {
                increasingHeightsStack.push(h) // [0,4]
                widthStack.push(i) // [-1,0]
            } else {
                while (increasingHeightsStack.peek() > h) {
                    val prevH = increasingHeightsStack.pop()
                    val prevI = widthStack.pop()
                    val width = i - widthStack.peek() - 1
                    val rec = width * prevH
                    // val rec = (i - prevI)*prevH
                    maxRect = max(maxRect, rec)
                }
                increasingHeightsStack.push(h) // [0,1]
                widthStack.push(i) // [-1,2]
            }
        }

        while (widthStack.peek() != 0) {
            val curH = increasingHeightsStack.pop()
            val curI = widthStack.pop()
            val width = heights.size - widthStack.peek()
            val rec = width * curH
            maxRect = max(maxRect, rec)
        }

        return maxRect
    }
}
