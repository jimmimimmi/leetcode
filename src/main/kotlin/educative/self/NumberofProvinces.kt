package educative.self

// https://leetcode.com/problems/number-of-provinces/description/
class NumberofProvinces {
    private fun findParent(parents: IntArray, nodeIdx: Int): Int {
        val p1 = parents[nodeIdx]
        if (p1 == nodeIdx) {
            return p1
        }
        val p2 = findParent(parents, p1)
        parents[nodeIdx] = p2
        return p2
    }

    private fun union(n1: Int, n2: Int, parent: IntArray, ranks: IntArray) {
        val p1 = findParent(parent, n1)
        val p2 = findParent(parent, n2)
        if (p1 == p2) {
            return
        }
        val r1 = ranks[p1]
        val r2 = ranks[p2]
        if (r1 >= r2) {
            parent[p2] = p1
            ranks[p1] += ranks[p2]
        } else {
            parent[p1] = p2
            ranks[p2] += ranks[p1]
        }
    }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val parents = IntArray(isConnected.size) { 0 }
        for (i in 0 until parents.size) {
            parents[i] = i
        }
        val ranks = IntArray(isConnected.size) { 1 }
        for (i in 0 until isConnected.size) {
            for (j in 0 until isConnected.size) {
                if (i != j && isConnected[i][j] == 1) {
                    union(i, j, parents, ranks)
                }
            }
        }
        for (i in 0 until isConnected.size) {
            findParent(parents, i)
        }
        return parents.filterIndexed { i, v -> i == v }.size
    }
}
