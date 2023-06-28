package com.educative.grokking.exercises;

import java.util.*;

//https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
public class FindAllRecipes {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        var graph = new HashMap<String, HashSet<String>>();
        for (var recipe : recipes) {
            graph.put(recipe, new HashSet<>());
        }
        for (var ingredientList : ingredients) {
            for (var ingredient : ingredientList) {
                graph.put(ingredient, new HashSet<>());
            }
        }
        for (int i = 0; i < recipes.length; i++) {
            for (var ingredient : ingredients.get(i)) {
                graph.get(recipes[i]).add(ingredient);
            }
        }
        var suppliesSet = new HashSet<>(List.of(supplies));

        List<String> allRecipes = new ArrayList<>();
        var cache = new HashMap<String, HashSet<String>>();
        for (var recipe : recipes) {
            var neededIngredients = extractAllIngredientsDfs(recipe, graph, cache, new HashSet<>());
            if (neededIngredients != null) {
                var ok = true;
                for (String i : neededIngredients) {
                    if (!suppliesSet.contains(i)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    allRecipes.add(recipe);
                }
            }

        }
        return allRecipes;
    }

    private static Set<String> extractAllIngredientsDfs(
            String recipeOrIngredient,
            HashMap<String, HashSet<String>> graph,
            HashMap<String, HashSet<String>> cache,
            HashSet<String> visited) {

        var ingredients = graph.get(recipeOrIngredient);
        if (ingredients == null || ingredients.isEmpty()) {
            return Set.of(recipeOrIngredient);
        }
        if (cache.containsKey(recipeOrIngredient)) {
            return cache.get(recipeOrIngredient);
        }
        if (visited.contains(recipeOrIngredient)) {
            cache.put(recipeOrIngredient, null);
            return null;
        }
        visited.add(recipeOrIngredient);
        var result = new HashSet<String>();
        for (var ingrOrRecipe : ingredients) {
            var res = extractAllIngredientsDfs(ingrOrRecipe, graph, cache, visited);
            if (res == null) {
                cache.put(recipeOrIngredient, null);
                return null;
            }
            result.addAll(res);
        }
        visited.remove(recipeOrIngredient);
        cache.put(recipeOrIngredient, result);
        return result;
    }
}
