package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class PathsInMazeTest extends TestCase {

    public void testNumberOfPaths() {
        PathsInMaze.numberOfPaths(5, new int[][]{{1, 2}, {5, 2}, {4, 1}, {3, 1}, {3, 4}});
    }
}