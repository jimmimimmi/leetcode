package prefixsum

// https://leetcode.com/problems/frequency-of-the-most-frequent-element/
class `Frequency-of-the-most-frequent-element` {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        val sortedNums = nums.sorted()
        val prefixSums = LongArray(nums.size) { 0L }
        prefixSums[0] = sortedNums[0].toLong()
        for (i in 1 until prefixSums.size) {
            prefixSums[i] = prefixSums[i - 1] + sortedNums[i]
        }

        var bestFreq = 1
        val kLong = k.toLong()

        for (i in 1 until nums.size) {
            var left = -1
            var right = i + 1

            while (right - left > 1) {
                val m = left + (right - left) / 2
                val width = i - m + 1
                val origSum = if (m == 0) prefixSums[i] else prefixSums[i] - prefixSums[m - 1]
                val newSum = width.toLong() * sortedNums[i]
                val cost = newSum - origSum
                if (cost <= kLong) {
                    bestFreq = kotlin.math.max(bestFreq, width)
                    right = m
                } else {
                    left = m
                }
            }
        }
        return bestFreq
    }
}
