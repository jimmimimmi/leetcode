package educative.customstructures

import java.util.*

class SnapshotArray(private val length: Int) {
    private var snapId = 0
    private val trees = Array(length) {
        val map = TreeMap<Int, Int>()
        map[0] = 0
        map
    }

    fun set(index: Int, `val`: Int) {
        trees[index][snapId] = `val`
    }

    fun snap(): Int {
        snapId++
        return snapId - 1
    }

    fun get(index: Int, snap_id: Int): Int =
        trees[index].floorEntry(snap_id).value
}
