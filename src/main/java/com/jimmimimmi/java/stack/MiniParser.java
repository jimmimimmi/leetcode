package com.jimmimimmi.java.stack;

import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/mini-parser/
/*
385. Mini Parser
Medium

231

773

Add to List

Share
Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
 */
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}

public class MiniParser {
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if (s.charAt(0) != '[') {
            int num  = Integer.parseInt(s);
            res.setInteger(num);
            return res;
        }

        s = s.substring(1, s.length() - 1);
        if (s.isEmpty()) {
            return new NestedInteger();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') {
                    Stack<Character> stack = new Stack<>();
                    stack.push(s.charAt(i));
                    int j = i+1;
                    while (j < s.length() && !stack.isEmpty()) {
                        if (s.charAt(j) == '[') {
                            stack.push('[');
                        } else if (s.charAt(j) == ']') {
                            stack.pop();
                        }
                        ++j;
                    }

                    res.add(deserialize(s.substring(i, j)));
                    i = j;
                } else if (s.charAt(i) == ',') {
                    res.add(deserialize(sb.toString()));
                    sb = new StringBuilder();
                } else {
                    sb.append(s.charAt(i));
                }
            }
            if (sb.length() != 0) {
                res.add(deserialize(sb.toString()));
            }
        }
        return res;
    }

}
