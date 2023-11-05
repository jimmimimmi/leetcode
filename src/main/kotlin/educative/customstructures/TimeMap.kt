package educative.customstructures

import java.util.TreeMap

// https://leetcode.com/problems/time-based-key-value-store/
class TimeMap {
    val map = HashMap<String, TreeMap<Int, String>>()
    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { TreeMap() }[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        return map[key]?.floorEntry(timestamp)?.value ?: ""
    }
}

class TimeMap2 {
    val map = HashMap<String, ArrayList<Pair<Int, String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        val arr = map.computeIfAbsent(key) { ArrayList() }
        arr.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val arr = map.computeIfAbsent(key) { ArrayList() }
        if (arr.isEmpty()) {
            return ""
        }

        var left = 0
        var right = arr.size - 1
        var mostRecent = -1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (arr[mid].first <= timestamp) {
                mostRecent = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return if (mostRecent != -1) arr[mostRecent].second else ""
    }
}
