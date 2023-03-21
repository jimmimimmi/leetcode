package com.jimmimimmi.java.repetition;

import java.util.*;
import java.util.stream.Collectors;

class GenerateParenthesis {
    class GenerateParenthesis_brute_force {
        public List<String> generateParenthesis(int n) {
            var string = new char[2 * n];
            var result = new ArrayList<String>();
            explore(string, 0, result);

            return result;
        }

        private void explore(char[] string, int startIdx, List<String> result) {
            if (startIdx == string.length) {
                if (isValid(string)) result.add(new String(string));
                return;
            }

            string[startIdx] = '(';
            explore(string, startIdx + 1, result);
            string[startIdx] = ')';
            explore(string, startIdx + 1, result);
        }

        private boolean isValid(char[] string) {
            int count = 0;
            for (char c : string
            ) {
                if (c == '(') count++;
                else count--;
                if (count < 0) return false;
            }
            return count == 0;
        }
    }


    static class GenerateParenthesis_backtracking {
        public List<String> generateParenthesis(int n) {
            var result = new ArrayList<String>();

            explore("", 0, 0, n, result);
            return result;
        }

        private void explore(String chars, int openCount, int closeCount, int n, List<String> result) {
            if (2 * n == chars.length()) {
                result.add(chars);
                return;
            }

            if (openCount < n) {
                explore(chars + "(", openCount + 1, closeCount, n, result);
            }

            if (closeCount < openCount) {
                explore(chars + ")", openCount, closeCount + 1, n, result);
            }
        }
    }

}
