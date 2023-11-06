package educative.bitwise

// https://leetcode.com/problems/reverse-bits/
class ReverseBits {
    fun reverseBits(n: Int): Int {
        val hashSet = HashSet<Int>()
        var res = 0
        for (i in 0 until Int.SIZE_BITS) {
            val ithBit = (n shr i) and 1
            res = res or (ithBit shl (Int.SIZE_BITS - 1 - i))
        }

        return res
    }
}
