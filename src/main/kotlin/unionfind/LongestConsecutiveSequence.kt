package unionfind

import kotlin.math.max

// https://leetcode.com/problems/longest-consecutive-sequence/description/
class LongestConsecutiveSequence {
    private fun findParent(n: Int, parents: MutableMap<Int, Int>): Int {
        val p1 = parents[n]!!
        if (p1 == n) return n

        val p2 = findParent(p1, parents)
        parents[n] = p2

        return p2
    }

    private fun union(a: Int, b: Int, parents: MutableMap<Int, Int>, ranks: MutableMap<Int, Int>) {
        val parentA = findParent(a, parents)
        val parentB = findParent(b, parents)

        if (parentA == parentB) return

        val aRank = ranks[parentA]!!
        val bRank = ranks[parentB]!!
        if (aRank >= bRank) {
            ranks[parentA] = aRank + bRank
            parents[parentB] = parentA
        } else {
            ranks[parentB] = aRank + bRank
            parents[parentA] = parentB
        }
    }

    fun longestConsecutive(nums: IntArray): Int {
        val parents = nums.map { it to it }.toMap().toMutableMap()
        val ranks = nums.map { it to 1 }.toMap().toMutableMap()

        nums.forEach { n ->
            if (parents.containsKey(n - 1)) {
                union(n, n - 1, parents, ranks)
            }
            if (parents.containsKey(n + 1)) {
                union(n, n + 1, parents, ranks)
            }
        }

        return ranks.values.max()
    }

    fun longestConsecutiveAlternative(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return 1
        val hashSet = HashSet<Int>()
        nums.forEach { hashSet.add(it) }
        var longestSize = 0
        var isNumberStartOfSequence: Boolean
        for (num in nums) {
            isNumberStartOfSequence = !hashSet.contains(num - 1)
            if (isNumberStartOfSequence) {
                var nextConsecutiveNumber = num + 1
                var currentSize = 1
                while (hashSet.contains(nextConsecutiveNumber)) {
                    nextConsecutiveNumber++
                    currentSize++
                }
                longestSize = max(longestSize, currentSize)
            }
        }
        return longestSize
    }
}
