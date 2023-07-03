package com.educative.grokking.exercises;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {

        var stack = new Stack<Character>();
        for (var c : s.toCharArray()) {
            if (stack.empty() || !stack.peek().equals(c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        var reversedStack = new Stack<Character>();
        while (!stack.empty()) {
            reversedStack.push(stack.pop());
        }
        var sb = new StringBuilder();
        while (!reversedStack.empty()) {
            sb.append(reversedStack.pop());
        }

        return sb.toString();
    }
}
