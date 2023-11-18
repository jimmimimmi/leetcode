package educative.self

import junit.framework.TestCase

class Numberof1BitsTest : TestCase() {

    fun testHammingWeight() {
        // 11111111111111111111111111111101
        Numberof1Bits().hammingWeight(-3)
    }
}