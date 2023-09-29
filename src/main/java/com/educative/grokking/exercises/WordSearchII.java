package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/description/
public class WordSearchII {
    static class Trie {
        Trie[] childs = new Trie[26];
        String word = null;
    }

    private static int[][] neighbours = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void dfs(int row, int column, Trie node, char[][] grid, List<String> result) {
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        if (column < 0 || row < 0 || column >= grid[0].length || row >= grid.length) {
            return;
        }
        var currChar = grid[row][column];
        if (currChar == '.') return;
        var child = node.childs[currChar - 'A'];
        if (child == null) return;

        grid[row][column] = '.';

        for (var next : neighbours) {
            var nextRow = row + next[0];
            var nextColumn = column + next[1];
            dfs(nextRow, nextColumn, child, grid, result);
        }

        grid[row][column] = currChar;
    }

    public static List<String> findStrings(char[][] grid, String[] words) {
        var root = new Trie();
        for (var word : words) {
            var node = root;
            for (var i = 0; i < word.length(); i++) {
                var idx = word.charAt(i) - 'A';
                if (node.childs[idx] == null) {
                    node.childs[idx] = new Trie();
                }
                if (i == word.length() - 1) {
                    node.childs[idx].word = word;
                }
                node = node.childs[idx];
            }
        }


        var res = new ArrayList<String>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(i, j, root, grid, res);

            }
        }

        return res;
    }
}
