package prefixsum

import kotlin.math.abs

class MaximizetheConfusionofanExam {

    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        val m1 = maxConsecutiveAnswersInternal(answerKey, k, 'T')
        val m2 = maxConsecutiveAnswersInternal(answerKey, k, 'F')

        return kotlin.math.max(m1, m2)
    }

    private fun maxConsecutiveAnswersInternal(answerKey: String, k: Int, char: Char): Int {
        val chars = answerKey.toCharArray()
        val prefixOfT = IntArray(chars.size + 1) { 0 }
        for (i in 0 until chars.size) {
            val incT = if (chars[i] == char) 1 else -1
            prefixOfT[i + 1] = prefixOfT[i] + incT
        }

        var left = 0
        var maxWindow = 0

        /*

        "TFFT"

        "TTTT"   width = 4, dist = 4
         */
        for (right in 1 until prefixOfT.size) {
            while (left <= right) {
                val dist = abs(prefixOfT[right] - prefixOfT[left])
                val maxDist = right - left - k
                if (dist < maxDist) {
                    left++
                } else {
                    break
                }
            }
            maxWindow = kotlin.math.max(maxWindow, right - left)
        }
        return maxWindow
    }
}
