package com.jimmimimmi.java.backtracking;

//https://leetcode.com/problems/word-search-ii/

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class TrieFactory {
    public TrieNode create(String[] words) {
        var root = new TrieNode();
        for (String word : words) {
            var current = root;
            for (int i = 0; i < word.length(); i++) {
                var c = word.charAt(i);
                var child = current.children[c - 'a'];
                if (child == null) {
                    child = new TrieNode();
                    child.prefix = word.substring(0, i + 1);
                    current.children[c - 'a'] = child;
                }
                if (i == word.length() - 1) child.completedWord = true;
                current = child;
            }
        }
        return root;
    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String prefix;
    public boolean completedWord;
}

public class WordSearchII {

    private int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void explore(char[][] board, boolean[][] visited, int row, int column, TrieNode node, HashSet<String> result) {
        var child = node.children[board[row][column] - 'a'];
        if (child == null) {
            return;
        } else {
            if (child.completedWord) {
                result.add(child.prefix);
            }

            visited[row][column] = true;

            for (int[] move : movements) {
                var nextRow = row + move[0];
                var nextColumn = column + move[1];
                if (nextRow >= 0 && nextRow < board.length && nextColumn >= 0 && nextColumn < board[0].length && !visited[nextRow][nextColumn]) {
                    explore(board, visited, nextRow, nextColumn, child, result);
                }
            }
            visited[row][column] = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0)
            return Collections.emptyList();

        var root = new TrieFactory().create(words);
        var result = new HashSet<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                explore(board, new boolean[board.length][board[0].length], i, j, root, result);
            }
        }

        return new ArrayList<>(result);
    }
}
