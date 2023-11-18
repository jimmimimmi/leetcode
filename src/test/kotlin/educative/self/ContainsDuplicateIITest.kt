package educative.self

import junit.framework.TestCase

class ContainsDuplicateIITest : TestCase() {

    fun testContainsNearbyDuplicate() {
      println( ContainsDuplicateII().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 3))
    }
}
