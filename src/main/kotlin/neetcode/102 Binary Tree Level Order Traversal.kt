package neetcode

// 102. Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
class `102 Binary Tree Level Order Traversal` {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        if (root != null) {
            queue.addLast(root!!)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size
            val subList = mutableListOf<Int>()
            result.add(subList)
            for (i in 1..size) {
                val n = queue.removeFirst()
                subList.add(n.`val`)
                if (n.left != null) {
                    queue.addLast(n.left!!)
                }

                if (n.right != null) {
                    queue.addLast(n.right!!)
                }
            }
        }

        return result
    }
}