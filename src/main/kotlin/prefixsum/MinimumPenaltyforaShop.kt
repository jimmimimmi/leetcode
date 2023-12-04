package prefixsum

// https://leetcode.com/problems/minimum-penalty-for-a-shop/
class MinimumPenaltyforaShop {
    fun bestClosingTime(customers: String): Int {
        val chars = customers.toCharArray()

        if (chars.size == 1) {
            if (chars.first() == 'Y') {
                return 1
            } else {
                return 0
            }
        }
        val closeAll = chars.fold(0) { acc, v ->
            if (v == 'Y') {
                acc + 1
            } else {
                acc
            }
        }

        val result = HashMap<Int, Int>()
        result[closeAll] = 0
        var penalty = closeAll

        var best = closeAll
        for (i in 1..chars.size) {
            if (chars[i - 1] == 'Y') {
                penalty--
            } else {
                penalty++
            }

            result.computeIfAbsent(penalty) { i }
            best = kotlin.math.min(best, penalty)
        }

        return result[best]!!
    }
}
