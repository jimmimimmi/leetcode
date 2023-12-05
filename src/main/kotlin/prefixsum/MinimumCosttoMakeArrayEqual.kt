package prefixsum

// https://leetcode.com/problems/minimum-cost-to-make-array-equal/description/
class MinimumCosttoMakeArrayEqual {
    fun minCost(nums: IntArray, cost: IntArray): Long {
        val numAndCosts = ArrayList<Pair<Int, Int>>()
        for (i in 0 until nums.size) {
            numAndCosts.add(nums[i] to cost[i])
        }

        val numAndCostsSorted = numAndCosts.sortedBy { it.first }
        val prefixSum = LongArray(nums.size) { 0L }
        prefixSum[0] = numAndCostsSorted[0].second.toLong()
        var costForAdjustToFirst = 0L
        for (i in 1 until numAndCostsSorted.size) {
            prefixSum[i] = numAndCostsSorted[i].second + prefixSum[i - 1]
            costForAdjustToFirst +=
                (numAndCostsSorted[i].first.toLong() - numAndCostsSorted[0].first.toLong()) *
                numAndCostsSorted[i].second.toLong()
        }

        var res = costForAdjustToFirst
        var curCost = costForAdjustToFirst

        for (i in 1 until numAndCostsSorted.size) {
            val dist = (numAndCostsSorted[i].first - numAndCostsSorted[i - 1].first)
            // curCost -= numAndCostsSorted[i].first * numAndCostsSorted[i].second
            curCost += dist * prefixSum[i - 1]
            curCost -= dist * (prefixSum.last() - prefixSum[i - 1])

            if (curCost < res) {
                res = curCost
            }
        }

        return res
    }
}
