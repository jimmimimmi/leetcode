package neetcode

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// 104. Maximum Depth of Binary Tree
class `104MaximumDepthofBinaryTree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun getDepth(n: TreeNode?, depth: Int): Int {
        if (n == null) return depth
        var l = getDepth(n.left, depth + 1)
        var r = getDepth(n.right, depth + 1)

        return kotlin.math.max(l, r)
    }

    fun maxDepth(root: TreeNode?): Int {
        return getDepth(root, 0)
    }
}