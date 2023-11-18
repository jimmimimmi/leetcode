package educative.self

// https://leetcode.com/problems/majority-element/submissions/
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }

        var cur = nums[0]
        var counter = 1
        nums.drop(1).forEach {
            if (it == cur) {
                counter++
            } else {
                if (counter == 0) {
                    cur = it
                } else {
                    counter--
                }
            }
        }

        return cur
    }
}
