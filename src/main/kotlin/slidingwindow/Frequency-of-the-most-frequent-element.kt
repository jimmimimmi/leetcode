package slidingwindow

// https://leetcode.com/problems/frequency-of-the-most-frequent-element/
class `Frequency-of-the-most-frequent-element` {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        val sortedNums = nums.sorted()

        var l = 0
        var r = 0
        var runningSum = sortedNums[0].toLong()
        var bestFreq = 1
        val kLong = k.toLong()

        while (r < sortedNums.size) {
            val width = r - l + 1
            val adjustedSum = width.toLong() * sortedNums[r]
            val cost = adjustedSum - runningSum
            if (cost <= kLong) {
                bestFreq = kotlin.math.max(bestFreq, width)
                r++
                if (r < sortedNums.size) {
                    runningSum += sortedNums[r]
                }
            } else {
                runningSum -= sortedNums[l]
                l++
            }
        }

        return bestFreq
    }
}
