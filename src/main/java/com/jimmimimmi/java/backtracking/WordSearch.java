package com.jimmimimmi.java.backtracking;

//https://leetcode.com/problems/word-search/

/*
79. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

 */

public class WordSearch {

    private int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean explore(char[][] board, String word, int row, int column, int charIdx, boolean[][] visited) {
        if (board[row][column] != word.charAt(charIdx))
            return false;
        else if (charIdx == word.length() - 1)
            return true;
        else {
            visited[row][column] = true;
            for (int[] move : movements) {
                var nextRow = row + move[0];
                var nextColumn = column + move[1];
                if (nextRow >= 0 &&
                        nextRow < board.length &&
                        nextColumn >= 0 &&
                        nextColumn < board[0].length &&
                        !visited[nextRow][nextColumn]) {
                    var exploreResult = explore(board, word, nextRow, nextColumn, charIdx + 1, visited);
                    if (exploreResult)
                        return true;
                }
            }
            visited[row][column] = false;
            return false;
        }
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                var res = explore(board, word, i, j, 0, new boolean[board.length][board[0].length]);
                if (res) return true;
            }
        }

        return false;
    }
}
