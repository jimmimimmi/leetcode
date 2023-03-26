package com.leetcode;

/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.


Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N417_Pacific_Atlantic_Water_Flow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // need to repeat exploration procedure below twice: for Atlantic checking and Pacific checking

        // Procedure:
        // for each cell start exploration
        // take it
        // check
        // IF it is near the ocean
        // THEN mark it and the whole path of cells leading to this cell as correct ones
        // ELSE IF it is neighbour of already marked as a correct one cell then again mark the cell and the path
        // ELSE mark as visited and put all non visited non explored neighbours with fewer high into stack
        // continue while stack is not empty
        // when the stack is empty find a next not explored cell

        var pacificOk = new boolean[heights.length][heights[0].length];
        var atlanticOk = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights[0].length; i++) {
            proceed(0, i, pacificOk, heights);
            proceed(heights.length - 1, i, atlanticOk, heights);
        }
        for (int i = 0; i < heights.length; i++) {
            proceed(i, 0, pacificOk, heights);
            proceed(i, heights[0].length - 1, atlanticOk, heights);
        }

        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacificOk[i][j] && atlanticOk[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void proceed(int i, int j, boolean[][] results, int[][] heights) {
        if (results[i][j]) return;
        results[i][j] = true;
        for (int[] direction : directions) {
            var nextRow = i + direction[0];
            var nextCol = j + direction[1];
            if (nextRow < 0 ||  nextRow >= heights.length || nextCol < 0 || nextCol >= heights[0].length){
                continue;
            }

            if (heights[nextRow][nextCol] >= heights[i][j]) {
                proceed(nextRow, nextCol, results, heights);
            }
        }
    }
}
