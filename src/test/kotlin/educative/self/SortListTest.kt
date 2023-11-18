package educative.self

import junit.framework.TestCase

class SortListTest : TestCase() {

    fun testSortList() {
        SortList().sortList(
            SortList.ListNode(4).apply {
                next = SortList.ListNode(2).apply {
                    next = SortList.ListNode(1).apply {
                        next = SortList.ListNode(3)
                    }
                }
            },
        )
    }
}
