package educative.bitwise

import junit.framework.TestCase

class ComplementofBase10IntegerTest : TestCase() {

    fun testBitwiseComplement() {
        val complementofBase10Integer = ComplementofBase10Integer()
        assertEquals(2, complementofBase10Integer.bitwiseComplement(5))
        assertEquals(0, complementofBase10Integer.bitwiseComplement(7))
        assertEquals(5, complementofBase10Integer.bitwiseComplement(10))
    }
}