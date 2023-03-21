package com.jimmimimmi.java.stack;

import java.util.ArrayDeque;

//https://leetcode.com/problems/simplify-path/
/*
71. Simplify Path
Medium

713

1671

Add to List

Share
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"

INPUT: "/home/foo/blabla/./..////../../../.."
stack:
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        var directoriesStack = new ArrayDeque<String>();
        int currentIndex = 0;
        var currentDirectory = new StringBuilder();
        while (currentIndex < path.length()) {
            var currentChar = path.charAt(currentIndex);

            if (currentChar == '/') {
                flush(directoriesStack, currentDirectory.toString());
                currentDirectory = new StringBuilder();
            } else {
                currentDirectory.append(currentChar);
            }

            currentIndex++;
        }

        flush(directoriesStack, currentDirectory.toString());

        var resultPath = new StringBuilder();
        while (!directoriesStack.isEmpty()) {
            var currentDir = directoriesStack.removeFirst();
            resultPath.append('/');
            resultPath.append(currentDir);
        }
        if (resultPath.length() == 0) return "/";
        else return resultPath.toString();

    }

    private void flush(ArrayDeque<String> directoriesStack, String dir) {
        if (dir.length() != 0) {
            if (dir.equals("..") && !directoriesStack.isEmpty()) {
                directoriesStack.removeLast();
            } else if (!dir.equals(".") && !dir.equals("..")) {
                directoriesStack.addLast(dir);
            }
        }
    }
}
