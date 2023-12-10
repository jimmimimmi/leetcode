package binarysearch

import junit.framework.TestCase

class FindClosestTest : TestCase() {

    fun testGetClosest() {
        /*

        [3, 17, 18, 25]:
        1,2,3 => 0
        4,5,6,7,8,9,10,11,12,13,14,15,16,17 => 1
        18 => 2
        19,20,21,22,23,24,25 => 2
         */
        for (i in 1..25)
            println(i to FindClosest().getClosestFromBelowInclusive(intArrayOf(3, 17, 18, 25), i))
    }
}
