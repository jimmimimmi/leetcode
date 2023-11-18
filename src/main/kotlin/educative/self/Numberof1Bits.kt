package educative.self

// https://leetcode.com/problems/number-of-1-bits/description/
class Numberof1Bits {
    fun hammingWeight(n: Int): Int {
        var result = 0
        var mask = 1
        for (i in 0 until Int.SIZE_BITS) {
            if (n and mask != 0) {
                result++
            }
            mask = mask shl 1
        }

        return result
    }

    /*
    The key idea here is to realize that for any number n,
    doing a bit-wise AND of n and n−1 flips the least-significant 1-bit in n to 0.
    Why? Consider the binary representations of n and n−1.
     */
    fun hammingWeightFast(n: Int): Int {
        var cur = n
        var res = 0
        while (cur != 0) {
            res++
            cur = cur and (cur - 1)
        }
        return res
    }
}
