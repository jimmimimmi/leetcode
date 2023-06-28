package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.List;

public class FindAllRecipesTest extends TestCase {

    public void testFindAllRecipes() {
        System.out.println(FindAllRecipes.findAllRecipes(new String[]{"bread", "sandwich", "burger"},
                List.of(
                        List.of("yeast", "flour"),
                        List.of("bread", "meat"),
                        List.of("sandwich", "meat", "bread")
                ),
                new String[]{"yeast", "flour", "meat"}
        ));
    }
}