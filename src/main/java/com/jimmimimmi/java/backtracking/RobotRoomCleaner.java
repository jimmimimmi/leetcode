package com.jimmimimmi.java.backtracking;


//https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2794/
/*
Given a robot cleaner in a room modeled as a grid.
Each cell in the grid can be empty or blocked.
The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 */

import java.util.HashSet;

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}

/*
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:

The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.

 */


public class RobotRoomCleaner {

    class Cell {
        private final int row;
        private final int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (row != cell.row) return false;
            return column == cell.column;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + column;
            return result;
        }
    }

    private static final int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean moveBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        var moveResult = robot.move();
        robot.turnRight();
        robot.turnRight();
        return moveResult;
    }

    private void explore(Robot robot, int row, int column, int direction, HashSet<Cell> cleaned) {
        robot.clean();
        cleaned.add(new Cell(row, column));

        for (int i = 0; i < 4; i++) {
            var newDirection = (direction + i) % 4;
            var newRow = row + movements[newDirection][0];
            var newColumn =column + movements[newDirection][1];
            if (!cleaned.contains(new Cell(newRow, newColumn)) && robot.move()) {
                explore(robot, newRow, newColumn, newDirection, cleaned);
                moveBack(robot);
            }
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        explore(robot, 0, 0, 0, new HashSet<Cell>());
    }
}
