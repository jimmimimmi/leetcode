package neetcode

// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class `3 Longest Substring Without Repeating Characters` {
    fun lengthOfLongestSubstring(s: String): Int {

        val freqMap = mutableMapOf<Char, Int>()
        var l = 0

        var best = 0
        var chars = s.toCharArray()
        for (r in 0 until chars.size) {
            var freq = freqMap[chars[r]] ?: 0
            if (freq == 1) {
                while (l <= r && freq != 0) {
                    var leftFreq = freqMap[chars[l]]!!
                    freqMap[chars[l]] = leftFreq - 1
                    if (chars[l] == chars[r]) {
                        freq = leftFreq - 1
                    }
                    l++
                }
            }
            freqMap[chars[r]] = freq + 1
            best = kotlin.math.max(best, r - l + 1)
        }
        return best
    }
}