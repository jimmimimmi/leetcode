package arrays

// https://leetcode.com/problems/image-smoother/submissions/
class ImageSmoother {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val neighbours = arrayOf(
            -1 to -1,
            -1 to 0,
            -1 to 1,
            0 to -1,
            0 to 1,
            1 to -1,
            1 to 0,
            1 to 1,
        )
        val rows = img.size
        val columns = img[0].size
        val result = Array(rows) { IntArray(columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until img[0].size) {
                val neighCells = neighbours.map { i + it.first to j + it.second }
                    .filter {
                        it.first >= 0 &&
                            it.second >= 0 &&
                            it.first < rows &&
                            it.second < columns
                    }
                val sum = neighCells.fold(img[i][j]) { acc, pair ->
                    acc + img[pair.first][pair.second]
                }

                result[i][j] = sum / (neighCells.size + 1)
            }
        }

        return result
    }
}
