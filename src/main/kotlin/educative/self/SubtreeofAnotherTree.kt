package educative.self

class SubtreeofAnotherTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun compare(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) {
            return true
        }

        if (a == null || b == null) {
            return false
        }

        if (a.`val` != b.`val`) {
            return false
        }

        val leftCompare = compare(a?.left, b?.left)
        val rightCompare = compare(a?.right, b?.right)

        return leftCompare && rightCompare
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        val compare = compare(root, subRoot)
        if (compare) return true

        val leftCompare = isSubtree(root?.left, subRoot)
        if (leftCompare) return true

        val rightCompare = isSubtree(root?.right, subRoot)
        if (rightCompare) return true

        return false
    }
}
