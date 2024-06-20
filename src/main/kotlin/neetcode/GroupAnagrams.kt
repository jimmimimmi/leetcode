package neetcode

// https://leetcode.com/problems/group-anagrams/
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val arrayOfCount26 = strs.map { str ->
            val count26 = IntArray(26) { 0 }
            str.toCharArray().map { c ->
                count26[c - 'a'] += 1
            }
            str to count26.joinToString()
        }

        val groupByCounts26 = HashMap<String, ArrayList<String>>()
        arrayOfCount26.forEach { (str, count26) ->
            groupByCounts26
                .computeIfAbsent(count26) { ArrayList<String>() }
                .add(str)
        }

        return groupByCounts26.values.toList()

    }
}