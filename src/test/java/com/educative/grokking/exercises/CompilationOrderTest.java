package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class CompilationOrderTest extends TestCase {

    public void testFindCompilationOrder() {

        var init = new Character[][]{
                {'B', 'A'}, {'C', 'A'}, {'D', 'C'}, {'E', 'D'}, {'E', 'B'}
        };

        var dependencies = new ArrayList<ArrayList<Character>>();
        for (Character[] characters : init) {
            dependencies.add(new ArrayList<>(Arrays.asList(characters)));
        }


        System.out.println(CompilationOrder.findCompilationOrder(dependencies));
    }
}