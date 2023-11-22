package educative.self

// https://leetcode.com/problems/same-tree/description/
class SameTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }

        if (p == null || q == null) {
            return false
        }

        if (p.`val` != q.`val`) {
            return false
        }

        val leftRes = isSameTree(p!!.left, q!!.left)
        if (!leftRes) return false

        val rightRes = isSameTree(p!!.right, q!!.right)
        if (!rightRes) return false

        return true
    }
}
