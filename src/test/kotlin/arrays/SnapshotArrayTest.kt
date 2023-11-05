package arrays

import educative.customstructures.SnapshotArray
import junit.framework.TestCase

class SnapshotArrayTest : TestCase() {

    fun testSet() {
        val sut = SnapshotArray(3)
        sut.set(0, 5)
        sut.snap()
        sut.set(0, 6)
    }
}