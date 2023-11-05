package educative.bitwise

// https://leetcode.com/problems/flipping-an-image/
class FlippingAnImage {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        image.forEach { row ->
            row.reverse()
            for (i in row.indices) {
                row[i] = if (row[i] == 0) 1 else 0
            }
        }
        return image
    }
}
