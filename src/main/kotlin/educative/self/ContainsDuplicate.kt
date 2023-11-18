package educative.self

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        if (nums.size <= 1) {
            return false
        }
        val sorted = nums.sortedArray()
        var prev = sorted[0]
        for(i in 1 until sorted.size){
            val cur = sorted[i]
            if (cur == prev) {
                return true
            } else {
                prev = cur
            }
        }

        return false
    }
}