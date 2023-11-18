package educative.self

import junit.framework.TestCase

class MeetingRoomsIIITest : TestCase() {

    fun testMostBooked() {
        println(
            MeetingRoomsIII().mostBooked(
                3,
                arrayOf(
                    intArrayOf(0, 10),
                    intArrayOf(1, 9),
                    intArrayOf(2, 8),
                    intArrayOf(3, 7),
                    intArrayOf(4, 6),
                ),
            ),
        )
    }
}
