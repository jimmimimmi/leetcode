package com.educative.grokking.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/last-day-where-you-can-still-cross/
public class LastDayWhereYouCanStillCross {
    private static int findParent(int num, Map<Integer, Integer> parents) {
        parents.putIfAbsent(num, num);
        if (parents.get(num).equals(num)) {
            return num;
        } else {
            var res = findParent(parents.get(num), parents);
            parents.put(num, res);
            return res;
        }
    }

    private static int union(int a, int b,
                             int cols,
                             Map<Integer, Integer> parents,
                             Map<Integer, Integer> ranks,
                             Map<Integer, Integer> leftMost,
                             Map<Integer, Integer> rightMost
    ) {
        var parA = findParent(a, parents);
        var parB = findParent(b, parents);
        ranks.putIfAbsent(parA, 1);
        ranks.putIfAbsent(parB, 1);
        leftMost.putIfAbsent(parA, parA % cols);
        rightMost.putIfAbsent(parA, parA % cols);

        leftMost.putIfAbsent(parB, parB % cols);
        rightMost.putIfAbsent(parB, parB % cols);

        if (parA == parB) {
            return parA;
        }

        var newRank = ranks.get(parA) + ranks.get(parB);
        var newLeftMost = Math.min(leftMost.get(parA), leftMost.get(parB));
        var newRightMost = Math.max(rightMost.get(parA), rightMost.get(parB));
        if (ranks.get(parA) >= ranks.get(parB)) {
            ranks.put(parA, newRank);
            leftMost.put(parA, newLeftMost);
            rightMost.put(parA, newRightMost);
            parents.put(parB, parA);
            return parA;
        } else {
            ranks.put(parB, newRank);
            leftMost.put(parB, newLeftMost);
            rightMost.put(parB, newRightMost);
            parents.put(parA, parB);
            return parB;
        }
    }


    public static int lastDayToCross(int rows, int cols, int[][] waterCells) {

        var parents = new HashMap<Integer, Integer>();
        var ranks = new HashMap<Integer, Integer>();
        var leftMostCoord = new HashMap<Integer, Integer>();
        var rightMostCoord = new HashMap<Integer, Integer>();
        var flooded = new HashSet<Integer>();

        var neighbours = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1},
        };

        for (int i = 0; i < waterCells.length; i++) {
            var coord = waterCells[i];
            var row = coord[0] - 1;
            var col = coord[1] - 1;

            var num = row * cols + col;
            flooded.add(num);

            for (var n : neighbours) {
                var nextRow = row + n[0];
                var nextCol = col + n[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                    var nextNum = nextRow * cols + nextCol;
                    if (flooded.contains(nextNum)) {
                        var root = union(num, nextNum, cols, parents, ranks, leftMostCoord, rightMostCoord);
                        if (leftMostCoord.get(root) == 0 && rightMostCoord.get(root) == cols - 1) {
                            return i;
                        }
                    }
                }
            }


        }

        return -1;
    }
}
