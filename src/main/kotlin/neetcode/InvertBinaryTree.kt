package neetcode

// 226. Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/description/
class InvertBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root

        val l = invertTree(root!!.left)
        val r = invertTree(root!!.right)

        root.left = r
        root.right = l
        return root
    }
}