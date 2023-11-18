package educative.self

import kotlin.math.min

// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/
class MinimumNumberofFlipstoMaketheBinaryStringAlternating {
    fun minFlips(s: String): Int {
        val doubledString = (s + s).toCharArray()

        var zeroesAreEvenOnesAreOddMissCounter = 0
        var onesAreEvenZeroesAreOddMissCounter = 0

        val update = { idx: Int, inc: Int ->
            val c = doubledString[idx]
            if (idx and 1 == 1) {
                if (c == '1') {
                    onesAreEvenZeroesAreOddMissCounter += inc
                } else {
                    zeroesAreEvenOnesAreOddMissCounter += inc
                }
            } else {
                if (c == '1') {
                    zeroesAreEvenOnesAreOddMissCounter += inc
                } else {
                    onesAreEvenZeroesAreOddMissCounter += inc
                }
            }
        }

        var min = Int.MAX_VALUE
        for (right in 0 until doubledString.size) {
            update(right, 1)
            if (right >= s.length) {
                update(right - s.length, -1)
                min = min(min, min(onesAreEvenZeroesAreOddMissCounter, zeroesAreEvenOnesAreOddMissCounter))
            }
        }

        return min
    }
}
