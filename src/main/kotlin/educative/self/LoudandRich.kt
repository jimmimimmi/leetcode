package educative.self

// https://leetcode.com/problems/loud-and-rich/description/
class LoudandRich {
    private fun topologicalSort(
        graph: HashMap<Int, ArrayList<Int>>,
        quiet: IntArray,
        node: Int,
        result: Array<IntArray>,
    ) {
        if (result[node][0] != -1) {
            return
        }

        result[node][0] = quiet[node]
        result[node][1] = node

        val nextArr = graph[node]!!

        if (nextArr.isNotEmpty()) {
            nextArr.forEach {
                if (result[it][0] != -1) {
                    if (result[node][0] > result[it][0]) {
                        result[node][0] = result[it][0]
                        result[node][1] = result[it][1]
                    }
                } else {
                    topologicalSort(graph, quiet, it, result)
                    if (result[node][0] > result[it][0]) {
                        result[node][0] = result[it][0]
                        result[node][1] = result[it][1]
                    }
                }
            }
        }
    }

    fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val graph = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until quiet.size) {
            graph[i] = ArrayList<Int>()
        }

        richer.forEach {
            val from = it[1]
            val to = it[0]
            graph[from]!!.add(to)
        }

        val result = Array<IntArray>(quiet.size) { intArrayOf(-1, -1) }

        for (i in 0 until quiet.size) {
            topologicalSort(graph, quiet, i, result)
        }

        return result.map { it[1] }.toIntArray()
    }
}
