package educative.bitwise

import kotlin.math.min

// https://leetcode.com/problems/find-the-difference/description/
class FindTheDifference {
    fun findTheDifference(s: String, t: String): Char {
        val arr1 = s.toCharArray()
        val arr2 = t.toCharArray()
        var result = 0
        arr1.forEach { result = result xor it - 'a' }
        arr2.forEach { result = result xor it - 'a' }

        return 'a' + result
    }
}