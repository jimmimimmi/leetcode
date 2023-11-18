package educative.self

// https://leetcode.com/problems/permutations/description/
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        val cur = ArrayList<Int>()

        explore(cur, nums, res)
        return res
    }

    private fun explore(cur: ArrayList<Int>, nums: IntArray, res: ArrayList<List<Int>>) {
        if (cur.size == nums.size) {
            res.add(cur.map { it })
            return
        }

        nums.forEach {
            if (!cur.contains(it)){
                cur.add(it)
                explore(cur, nums, res)
                cur.removeAt(cur.size - 1)
            }
        }
    }
}
