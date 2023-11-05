package arrays

import junit.framework.TestCase

class ImageSmootherTest : TestCase() {

    fun testImageSmoother() {
        ImageSmoother().imageSmoother(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1),
            ),
        )
    }
}
