package binarysearch

class FindClosest {

    /*

        1,2,3 => 0
        4,5,6,7,8,9,10,11,12,13,14,15,16,17 => 1
        18 => 2
        19,20,21,22,23,24,25 => 2

         println(FindClosest().getClosest(intArrayOf(3, 17, 18, 25), 24))
         */

    fun getClosestFromBelowInclusive(nums: IntArray, target: Int): Int {
        /*
        [3, 17, 18, 25]:
        1,2,3 => 0
        4,5,6,7,8,9,10,11,12,13,14,15,16,17 => 1
        18 => 2
        19,20,21,22,23,24,25 => 2
         */
        var l = -1
        var r = nums.size

        while (r - l > 1) {
            val m = l + (r - l) / 2 // 2 + 1 = 3
            if (nums[m] >= target) {
                r = m
            } else {
                l = m
            }
        }
        return r
    }
}
