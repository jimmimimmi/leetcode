package educative.bitwise

import kotlin.math.log2

// https://leetcode.com/problems/complement-of-base-10-integer/
class ComplementofBase10Integer {
    fun bitwiseComplement(n: Int): Int {
        if (n == 0) {
            return 1
        }
        var result = 0
        var num = n
        var bit = 1
        while (num > 0) {
            val lastBit = num and 1
            if (lastBit == 0) result = result or bit
            bit = bit shl 1
            num = num shr 1
        }
        return result
    }

    fun bitwiseComplementViaLog(n: Int): Int {
        val lenghtMask = log2(n.toDouble()).toInt() + 1
        val mask = (1 shl lenghtMask) - 1
        return n xor mask
    }
}
