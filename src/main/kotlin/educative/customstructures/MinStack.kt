package educative.customstructures

import java.util.Stack
import kotlin.math.min

class MinStack {
    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()
    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.push(`val`)
            minStack.push(`val`)
        } else {
            val minValue = minStack.peek()
            val newMinValue = min(minValue, `val`)
            stack.push(`val`)
            minStack.push(newMinValue)
        }
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
