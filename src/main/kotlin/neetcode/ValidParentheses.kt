package neetcode

class ValidParentheses {
    fun getExpectedChar(c: Char): Char? {
        if (c == ']') return '['
        if (c == ')') return '('
        if (c == '}') return '{'

        return null
    }

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for(c in s){
            val expectedChar = getExpectedChar(c)
            if (expectedChar == null) {
              if (stack.isEmpty() || stack.last() == c) {
                  stack.addLast(c)
              }else {
                  return false
              }
           }else {
               if (stack.isEmpty() || stack.last() != expectedChar) {
                   return false
               }else {
                   stack.removeLast()
               }
           }
        }

        return stack.isEmpty()
    }
}