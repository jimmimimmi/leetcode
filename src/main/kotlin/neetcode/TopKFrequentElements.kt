package neetcode

// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/
class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = mutableMapOf<Int, Int>()
        nums.forEach {
            val prevVal = freqMap[it]
            freqMap[it] = (prevVal ?: 0) + 1
        }

        val allPossibleFreqArray = Array<MutableList<Int>>(nums.size) { mutableListOf() }

        freqMap.forEach { (num, freq) ->
            allPossibleFreqArray[freq - 1].add(num)
        }

        val result = mutableListOf<Int>()

        for (i in allPossibleFreqArray.size - 1 downTo 0) {
            for (num in allPossibleFreqArray[i]) {
                if (result.size < k) {
                    result.add(num)
                } else {
                    return result.toIntArray()
                }
            }

        }


        return result.toIntArray()

    }
}