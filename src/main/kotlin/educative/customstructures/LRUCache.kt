package educative.customstructures

// https://leetcode.com/problems/lru-cache/

class LRUNode(val key: Int, var value: Int, var prev: LRUNode? = null, var next: LRUNode? = null)
class LRUCache(capacity: Int) {
    private var size = 0
    private val maxSize = capacity
    private val map = HashMap<Int, LRUNode>()

    private val head: LRUNode = LRUNode(0, 0, null, null)
    private val tail: LRUNode = LRUNode(0, 0, null, null)

    init {
        head.next = tail
        tail.prev = head
    }

    fun removeFromList(node: LRUNode) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev

        node.next = null
        node.prev = null
    }

    fun addFirstToList(node: LRUNode) {
        node.next = head.next
        node.prev = head
        head.next!!.prev = node
        head.next = node
    }

    fun getNode(key: Int): LRUNode? {
        return map[key].let { node ->
            if (node != null) {
                removeFromList(node)
                addFirstToList(node)
            }
            node
        }
    }

    fun get(key: Int): Int = getNode(key)?.value ?: -1

    fun put(key: Int, value: Int) {
        val node = getNode(key)
        if (node != null) {
            node.value = value
        } else {
            val newnode = LRUNode(key, value, null, null)
            addFirstToList(newnode)
            map[key] = newnode
            if (size == maxSize) {
                val nodeToRemove = tail.prev
                if (nodeToRemove != head) {
                    map.remove(nodeToRemove!!.key)
                    removeFromList(nodeToRemove)
                }
            } else {
                size++
            }
        }
    }
}
