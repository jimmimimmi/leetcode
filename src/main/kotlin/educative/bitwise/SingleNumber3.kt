package educative.bitwise

// https://leetcode.com/problems/single-number-iii/
class SingleNumber3 {
    fun singleNumber(nums: IntArray): IntArray {
        var xorRes = 0
        nums.forEach { xorRes = xorRes xor it }

        var mask = 1
        while (mask and xorRes == 0) {
            mask = mask shl 1
        }

        var first = 0
        var second = 0

        nums.forEach {
            if (mask and it == 0) {
                first = first xor it
            } else {
                second = second xor it
            }
        }

        return intArrayOf(first, second)
    }
}
