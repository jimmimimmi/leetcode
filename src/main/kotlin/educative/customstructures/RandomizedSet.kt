package educative.customstructures

import java.util.Random

// https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {

    private val map = HashMap<Int, Int>()
    private val arr = ArrayList<Int>()

    fun insert(`val`: Int): Boolean {
        val idx = map[`val`]
        if (idx != null) return false

        arr.add(`val`)
        map[`val`] = arr.size - 1
        return true
    }

    fun remove(`val`: Int): Boolean {
        val idx = map[`val`] ?: return false

        arr[idx] = arr[arr.size - 1]
        map[arr[idx]] = idx

        map.remove(`val`)
        arr.removeAt(arr.size - 1)

        return true
    }

    fun getRandom(): Int {
        return arr[Random().nextInt(arr.size)]
    }
}
