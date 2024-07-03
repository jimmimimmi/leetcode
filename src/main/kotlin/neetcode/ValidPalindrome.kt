package neetcode

// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/description/
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {

        val chars = s.lowercase().toCharArray()
        var l = 0
        var r = chars.size - 1

        while (l < r) {
            while (!chars[l].isLetterOrDigit() && l < r) {
                l++
            }
            while (!chars[r].isLetterOrDigit() && l < r) {
                r--
            }

            if (chars[l] != chars[r]) return false
            l++
            r--
        }

        return true
    }
}