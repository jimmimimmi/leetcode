package neetcode

// 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/description/
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val chars = s.toCharArray()
        val runningFreqMap = mutableMapOf<Char, Int>()
        var l = 0
        val tFreqMap = t.toCharArray()
            .groupBy { it }
            .map { (k, v) -> k to v.size }.toMap()
        val remainFreqMap = tFreqMap.toMutableMap()
        var result: Pair<Int, Int>? = null
        for(r in 0 until chars.size){
            val c = chars[r]
            runningFreqMap[c] = (runningFreqMap[c] ?: 0) + 1
            remainFreqMap[c].let {
                if (it != null) {
                    if (it <= 1){ remainFreqMap.remove(c)}
                    else { remainFreqMap[c] = it - 1}
                }
            }
            while(l <= r &&
                remainFreqMap.isEmpty() &&
                (tFreqMap[chars[l]] == null ||
                        tFreqMap[chars[l]]!! < runningFreqMap[chars[l]]!!)){
                runningFreqMap[chars[l]] = runningFreqMap[chars[l]]!! - 1
                l++
            }
            if (remainFreqMap.isEmpty()) {
                if (result == null || result.second - result.first > (r - l)){
                    result = l to r
                }
            }
        }

        if (result == null) return ""
        val from = result.first
        val to = result.second
        return s.substring(from, to + 1)
    }
}