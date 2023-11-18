package educative.self

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
class NumberofConnectedComponentsinanUndirectedGraph {
    private fun findParent(parents: Array<Int>, n: Int): Int {
        val p1 = parents[n]
        if (p1 == n) {
            return p1
        }

        val p2 = findParent(parents, p1)
        parents[n] = p2

        return p2
    }

    private fun union(n1: Int, n2: Int, parents: Array<Int>, ranks: Array<Int>) {
        val p1 = findParent(parents, n1)
        val p2 = findParent(parents, n2)

        if (p1 == p2) {
            return
        }

        val r1 = ranks[p1]
        val r2 = ranks[p2]

        val totalRank = r1 + r2

        if (r1 >= r2) {
            parents[p2] = p1
            ranks[p1] = totalRank
        } else {
            parents[p1] = p2
            ranks[p2] = totalRank
        }
    }

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parents = (0 until n).toList().toTypedArray()
        val ranks = Array<Int>(n) { 1 }

        edges.forEach {
            val n1 = it[0]
            val n2 = it[1]

            union(n1, n2, parents, ranks)
        }

        (0 until n).forEach { findParent(parents, it) }

        return parents.mapIndexed { idx, p -> p == idx }.count { it }
    }
}
