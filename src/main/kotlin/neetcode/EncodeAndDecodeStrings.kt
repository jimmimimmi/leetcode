package neetcode

// 271. Encode and Decode Strings
// https://leetcode.com/problems/encode-and-decode-strings/description/
class EncodeAndDecodeStrings {

        fun encodeInt32To4Chars(num: Int): String {
            val sb = StringBuilder()
            val c1 = num.toChar()
            val c2 = (num shr 8).toChar()
            val c3 = (num shr 16).toChar()
            val c4 = (num shr 24).toChar()

            sb.append(c1)
            sb.append(c2)
            sb.append(c3)
            sb.append(c4)

            return sb.toString()
        }

        fun decode4CharsToInt32(str: String): Int {
            val sb = StringBuilder()
            val chars = str.toCharArray()
            val c1 = chars[0]
            val c2 = chars[1]
            val c3 = chars[2]
            val c4 = chars[3]

            var result: Int = 0
            result = result or c1.toInt()
            result = result or (c2.toInt() shl 8)
            result = result or (c3.toInt() shl 16)
            result = result or (c4.toInt() shl 24)

            return result
        }

        // Encodes a list of strings to a single string.
        fun encode(strs: List<String>): String {
            val sb = StringBuilder()

            strs.forEach {
                sb.append(encodeInt32To4Chars(it.length))
                sb.append(it)
            }
            return sb.toString()
        }

        // Decodes a single string to a list of strings.
        fun decode(s: String): List<String> {
            val chars = s.toCharArray()
            var idx = 0
            val result = mutableListOf<String>()
            while(idx < chars.size){
                val sbLength = StringBuilder()
                sbLength.append(chars[idx])
                sbLength.append(chars[idx+1])
                sbLength.append(chars[idx+2])
                sbLength.append(chars[idx+3])
                val length = decode4CharsToInt32(sbLength.toString())

                idx = idx + 4
                val nextWordIdx = idx + length
                val sbString = StringBuilder()
                while (idx < nextWordIdx) {
                    sbString.append(chars[idx])
                    idx++
                }
                result.add(sbString.toString())
            }

            return result.toList()
        }
}