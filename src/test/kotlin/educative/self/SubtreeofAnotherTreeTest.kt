package educative.self

import junit.framework.TestCase

class SubtreeofAnotherTreeTest : TestCase() {

    fun testIsSubtree() {
//        println(
//            SubtreeofAnotherTree().isSubtree(
//                SubtreeofAnotherTree.TreeNode(3).apply {
//                    left = SubtreeofAnotherTree.TreeNode(4).apply {
//                        left = SubtreeofAnotherTree.TreeNode(1)
//                        right = SubtreeofAnotherTree.TreeNode(2)
//                    }
//                    right = SubtreeofAnotherTree.TreeNode(5)
//                },
//                SubtreeofAnotherTree.TreeNode(4).apply {
//                    left = SubtreeofAnotherTree.TreeNode(1)
//                    right = SubtreeofAnotherTree.TreeNode(2)
//                },
//            ),
//        )

        println(
            SubtreeofAnotherTree().isSubtree(
                SubtreeofAnotherTree.TreeNode(3).apply {
                    left = SubtreeofAnotherTree.TreeNode(4).apply {
                        left = SubtreeofAnotherTree.TreeNode(1)
                        right = SubtreeofAnotherTree.TreeNode(2).apply {
                            left = SubtreeofAnotherTree.TreeNode(0)
                        }
                    }
                    right = SubtreeofAnotherTree.TreeNode(5)
                },
                SubtreeofAnotherTree.TreeNode(4).apply {
                    left = SubtreeofAnotherTree.TreeNode(1)
                    right = SubtreeofAnotherTree.TreeNode(2)
                },
            ),
        )
    }
}
