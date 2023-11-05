package educative.bitwise

// https://leetcode.com/problems/encode-and-decode-strings/
class EncodeandDecodeStrings {

    fun encodeLength(x: String): String {
        val sb = StringBuilder()
        sb.append(x.length.toChar())
        sb.append((x.length shr 8).toChar())
        sb.append((x.length shr 16).toChar())
        sb.append((x.length shr 24).toChar())
        return sb.toString()
    }

    fun decodeLength(arr: CharArray, idx: Int): Int {
        var result = 0

        result = result or arr[idx].code
        result = result or (arr[idx + 1].code shl 8)
        result = result or (arr[idx + 2].code shl 16)
        result = result or (arr[idx + 3].code shl 24)

        return result
    }

    fun encode(strs: List<String>): String {
        return strs.fold(StringBuilder()) { acc, s ->
            acc.append(encodeLength(s))
            acc.append(s.length)
        }.toString()
    }

    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val arr = s.toCharArray()
        var i = 0
        val result = ArrayList<String>()
        while (i < arr.size){
            val l = decodeLength(arr, i)
            val sb = StringBuilder()
            for (j in i + 4 until i + 4 + l){
                sb.append(arr[j])
            }
            result.add(sb.toString())
            i += 4 + l
        }
        return result
    }
}
