package educative.self

import junit.framework.TestCase

class ThreeSumTest : TestCase() {

    fun testThreeSum() {
        ThreeSum().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).forEach { println(it) }
    }
}