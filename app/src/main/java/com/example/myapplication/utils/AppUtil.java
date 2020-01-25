package com.example.myapplication.utils;

import com.example.myapplication.enums.CategoryEnum;
import com.example.myapplication.model.Ingredient;
import com.example.myapplication.model.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppUtil {

    static Map<String, Recipe> recipeMap = new HashMap<>();

    static {
        Recipe testRecipe = new Recipe();
        testRecipe.setCategory(CategoryEnum.HOT);
        testRecipe.setDescription("Залупа в лаваше");
        testRecipe.setName("Залупа");
        testRecipe.setIngredients(Arrays.asList(
                new Ingredient("Огурец", 1, "кг"),
                new Ingredient("Лаваш", 1, "шт.")
        ));
        recipeMap.put(testRecipe.getName(), testRecipe);
    }

    public static List<Recipe> getRecipesByCategory(CategoryEnum category) {
        Collection<Recipe> recipes = recipeMap.values();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getCategory().equals(category)) {
                filteredRecipes.add(recipe);
            }
        }

        return filteredRecipes;
    }

    public static void addRecipe(Recipe recipe) {
        recipeMap.put(recipe.getName(), recipe);
    }

    public static Recipe getRecipeByName(String recipeName) {
        return recipeMap.get(recipeName);
    }

    public static Collection<Recipe> getAllRecipes() {
        return recipeMap.values();
    }

    public static void deleteRecipe(String recipeName) {
        recipeMap.remove(recipeName);
    }

}
