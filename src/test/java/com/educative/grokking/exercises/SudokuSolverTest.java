package com.educative.grokking.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

public class SudokuSolverTest extends TestCase {

    public void testSolveSudoku() throws JsonProcessingException {

        System.out.println("RESULT \n\n" + new ObjectMapper().writeValueAsString(SudokuSolver.solveSudoku(new char[][]{

                {'.', '.', '.', '.', '.', '.', '.', '7', '.'},
                {'2', '7', '5', '.', '.', '.', '3', '1', '4'},
                {'.', '.', '.', '.', '2', '7', '.', '5', '.'},
                {'9', '8', '.', '.', '.', '.', '.', '3', '1'},
                {'.', '3', '1', '8', '.', '4', '.', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '8', '.', '5'},
                {'7', '.', '6', '2', '.', '.', '1', '8', '.'},
                {'.', '9', '.', '7', '.', '.', '.', '.', '.'},
                {'4', '1', '.', '.', '.', '5', '.', '.', '7'}


        })));
    }
}