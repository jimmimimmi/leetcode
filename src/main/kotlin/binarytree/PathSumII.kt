package binarytree

// https://leetcode.com/problems/path-sum-ii/description/
class PathSumII {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) {
            return ArrayList<List<Int>>()
        }

        val res = ArrayList<List<Int>>()
        explore(root, targetSum, ArrayList<Int>(), res)
        return res
    }

    fun explore(node: TreeNode, target: Int, currPath: ArrayList<Int>, result: ArrayList<List<Int>>) {
        val newTarget = target - node.`val`
        currPath.add(node.`val`)

        if (node.left == null && node.right == null) {
            if (newTarget == 0) {
                result.add(currPath.toList())
            }
        } else {
            if (node.left != null) explore(node.left!!, newTarget, currPath, result)
            if (node.right != null) explore(node.right!!, newTarget, currPath, result)
        }

        currPath.removeAt(currPath.size - 1)
    }
}
