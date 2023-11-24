package educative.self

// https://leetcode.com/problems/add-binary/description/
class AddBinary {
    fun addBinary(a: String, b: String): String {
        var car = 0
        val arr1 = a.toCharArray()
        val arr2 = b.toCharArray()

        var i1 = arr1.size - 1
        var i2 = arr2.size - 1

        val sb = StringBuilder()

        while (i1 >= 0 || i2 >= 0) {
            val c1 = if (i1 >= 0) arr1[i1] else '0'
            val c2 = if (i2 >= 0) arr2[i2] else '0'

            val val1 = c1 - '0'
            val val2 = c2 - '0'

            var nextCar = 0
            if (val1 + val2 > 1) {
                nextCar = 1
            }

            var res = (val1 xor val2) xor car
            if (res == 0 && car == 1) {
                nextCar = 1
            }
            car = nextCar

            sb.append(res)
            i1--
            i2--
        }
        if (car == 1) {
            sb.append('1')
        }

        return sb.toString().reversed()
    }
}
