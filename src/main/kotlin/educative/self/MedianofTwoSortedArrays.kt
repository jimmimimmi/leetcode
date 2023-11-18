package educative.self

import kotlin.math.*

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
class MedianofTwoSortedArrays {

    /*
    [1, 4, 6, 7]
    [2, 3, 5, 8, 9, 10, 11]

    total is 11

    ==> 9 (5th)

     [7, 16, 19, 29], 0-3
     [1, 4, 5, 8, 9, 11, 12] 0-6

    16 (1st)
    7
    1,4,5,8,9,     11,12


    1,4,      6,7
    2,3,5,8   9,10,11

     */

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)

        var aLeft = 0
        var aRight = nums1.size

        while (aLeft <= aRight) {
            val aMiddle = (aLeft + aRight) / 2
            val bMiddle = (nums1.size + nums2.size + 1) / 2 - aMiddle

            val aLeftPartMax = if (aMiddle - 1 in 0..aRight - 1) nums1[aMiddle - 1] else Int.MIN_VALUE
            val aRightPartMin = if (aMiddle in 0..aRight - 1) nums1[aMiddle] else Int.MAX_VALUE

            val bLeftPartMax = if (bMiddle - 1 in 0..nums2.size - 1) nums2[bMiddle - 1] else Int.MIN_VALUE
            val bRightPartMin = if (bMiddle in 0..nums2.size - 1) nums2[bMiddle] else Int.MAX_VALUE

            if (aLeftPartMax <= bRightPartMin && bLeftPartMax <= aRightPartMin) {
                return if ((nums1.size + nums2.size) % 2 == 0) {
                    (max(aLeftPartMax, bLeftPartMax) + min(aRightPartMin, bRightPartMin)) / 2.0
                } else {
                    max(aLeftPartMax, bLeftPartMax).toDouble()
                }
            } else if (aLeftPartMax > bRightPartMin) {
                aRight = aMiddle - 1
            } else {
                aLeft = aMiddle + 1
            }
        }

        return 0.0
    }
}
