package educative.self

import java.util.*

class ProductofArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size) {
            left[i] = left[i - 1] * nums[i - 1]
        }

        val right = IntArray(nums.size) { 1 }
        for (i in nums.size - 2 downTo 0) {
            right[i] = right[i + 1] * nums[i + 1]
        }

        return IntArray(nums.size) { left[it] * right[it] }
    }
}
