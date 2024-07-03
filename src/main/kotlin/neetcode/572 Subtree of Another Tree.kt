package neetcode

// 572. Subtree of Another Tree
// https://leetcode.com/problems/subtree-of-another-tree/description/
class `572 Subtree of Another Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // APPROACH 1
    fun preOrder(p: TreeNode?, ar: ArrayList<String>) {
        val separatorToDistiguish1And11 = "~"
        ar.add("$separatorToDistiguish1And11 ${p?.`val`}")
        if (p == null) return
        preOrder(p?.left, ar)
        preOrder(p?.right, ar)
    }

    fun isSubtreeWithStringCompare(root: TreeNode?, subRoot: TreeNode?): Boolean {
        val rootAr = ArrayList<String>()
        preOrder(root, rootAr)

        val subRootAr = ArrayList<String>()
        preOrder(subRoot, subRootAr)

        val rootStr = rootAr.joinToString()
        val subRootStr = subRootAr.joinToString()

        return rootStr.contains(subRootStr)
    }

    // APPROACH 2

    fun areSame(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) return true
        if (a == null || b == null) return false
        if (a?.`val` != b?.`val`) return false

        if (!areSame(a?.left, b?.left)) return false
        if (!areSame(a?.right, b?.right)) return false

        return true
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false

        if (areSame(root, subRoot)) return true

        if(isSubtree(root?.left, subRoot)) return true

        if(isSubtree(root?.right, subRoot)) return true

        return false
    }

}