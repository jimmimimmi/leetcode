package educative.bitwise

// https://leetcode.com/problems/single-number-ii/description/
class SingleNumber2 {

    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in 0 until Int.SIZE_BITS) {
            var resultI = 0
            nums.forEach {
                val ithBit = (it shr i) and 1
                resultI = resultI + ithBit
            }
            resultI %= 3
            result = result or (resultI shl i)
        }

        return result
    }
}
