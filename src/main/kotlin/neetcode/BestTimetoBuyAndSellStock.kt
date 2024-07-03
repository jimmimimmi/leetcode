package neetcode

// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class BestTimetoBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size <= 1) return 0
        var min = prices[0]
        var best = 0
        for(i in 1 until prices.size){
            if(prices[i] > min) {
                best = kotlin.math.max(best, prices[i] - min)
            }
            min = kotlin.math.min(min, prices[i])
        }

        return best
    }
}