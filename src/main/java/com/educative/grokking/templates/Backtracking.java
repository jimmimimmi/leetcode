package com.educative.grokking.templates;

// Template class for backtracking using dfs

import java.util.*;

class Backtracking {
    List<Character> state; // The current state
    List<Character> choices;  // Possible next moves based on current state
    List<List<Character>> res; // All possible valid states

    // Initialize state and choices
    Backtracking(List<Character> st, List<Character> ch) {
        state = st;
        choices = ch;
    }

    // To check the current state is a valid solution or not
    boolean isSolution(List<Character> state) {
        // Replace this placeholder return statement
        // with your code to check this solution
        return false;
    }

    // To check the current choice is a valid choice or not
    boolean isValid(char choice) {
        // Replace this placeholder return statement
        // with your code to check the validity of this choice
        return false;
    }

    // We can use this function to evaluate all the states and store the valid states
    void dfs(List<Character> state) {
        if (isSolution(state)) {
            res.add(state); // e.g. add a copy of the state to final result list
            return;
        }
        for (char choice : choices) {
            if (isValid(choice)) {
                state.add(choice); // make move
                dfs(state);
                int indexOfLastElement = state.size() - 1;
                state.remove(indexOfLastElement); // backtrack

            }
        }
    }
}