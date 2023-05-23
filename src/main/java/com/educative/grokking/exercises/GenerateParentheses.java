package com.educative.grokking.exercises;

import java.util.ArrayList;

public class GenerateParentheses {
    public static ArrayList<String> generateCombinations(int n) {

        ArrayList<String> result = new ArrayList<String>();
        recursive(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void recursive(int n, int openCount, int closeCount, StringBuilder output, ArrayList<String> result) {
        if (openCount == n && closeCount == n) {
            result.add(output.toString());
            return;
        }

        if (openCount < n) {
            output.append('(');
            recursive(n, openCount + 1, closeCount, output, result);
            output.deleteCharAt(output.length() - 1);
        }

        if (closeCount < openCount) {
            output.append(')');
            recursive(n, openCount, closeCount + 1, output, result);
            output.deleteCharAt(output.length() - 1);
        }
    }
}
