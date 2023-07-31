package com.educative.grokking.exercises;

import java.util.ArrayDeque;

// https://leetcode.com/problems/flood-fill/
public class FloodFill {
    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) return grid;
        var origValue = grid[sr][sc];
        if (origValue == target) return grid;

        var directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        var queueRow = new ArrayDeque<Integer>();
        var queueCol = new ArrayDeque<Integer>();
        queueRow.offer(sr);
        queueCol.offer(sc);

        while (!queueCol.isEmpty()) {
            var size = queueCol.size();
            for (int i = 0; i < size; i++) {
                var row = queueRow.poll();
                var col = queueCol.poll();
                grid[row][col] = target;

                for (var direction : directions) {
                    var nextRow = row + direction[0];
                    var nextCol = col + direction[1];
                    if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                        if (grid[nextRow][nextCol] == origValue) {
                            queueRow.offer(nextRow);
                            queueCol.offer(nextCol);
                        }
                    }
                }
            }
        }

        return grid;
    }
}
