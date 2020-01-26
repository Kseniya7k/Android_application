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
        testRecipe.setCategory(CategoryEnum.DESSERT);
        testRecipe.setDescription("Замесить тесто из ингредиентов. Поставить в тёплое место на 1 час." +
                "Вымесить ещё раз, сформировать шар и выпекать в духовке при 180 градусах 15 минут.");
        testRecipe.setName("Печенье особое");
        testRecipe.setIngredients(Arrays.asList(
                new Ingredient("мука", 1, "кг"),
                new Ingredient("молоко", 2, "ст"),
                new Ingredient("яйцо", 2, "шт"),
                new Ingredient("изюм", 1, "ст"),
                new Ingredient("дрожжи", 1, "пак")
        ));

        Recipe testRecipe1 = new Recipe();
        testRecipe1.setCategory(CategoryEnum.DESSERT);
        testRecipe1.setDescription("Замесить тесто из ингредиентов. Залить тесто в форму." +
                "Выпекать в духовке при 180 градусах 1 час. Готовность проверить деревянной зубочисткой");
        testRecipe1.setName("Корж для торта");
        testRecipe1.setIngredients(Arrays.asList(
                new Ingredient("мука", 500, "г"),
                new Ingredient("молоко", 200, "мл"),
                new Ingredient("разрызлитель", 1, "пак"),
                new Ingredient("ванилин", 1, "пак"),
                new Ingredient("яйцо", 5, "шт")
        ));

        Recipe testRecipe2 = new Recipe();
        testRecipe2.setCategory(CategoryEnum.HOT);
        testRecipe2.setDescription("Мясо оставить мариноваться в специях и подсолнечном масле 1 час. " +
                "Завернуть в фольгу и готовить в духовке 1 час до румяной корочки.");
        testRecipe2.setName("Синина по-царски");
        testRecipe2.setIngredients(Arrays.asList(
                new Ingredient("мясо", 500, "г"),
                new Ingredient("специи к мясу", 1, "пак"),
                new Ingredient("масло подсолнечное", 20, "мл"),
                new Ingredient("орехи", 100, "г")
        ));

        Recipe testRecipe3 = new Recipe();
        testRecipe3.setCategory(CategoryEnum.HOT);
        testRecipe3.setDescription("Мясо отбить,посолить поперчить, сверху положить лук,картофель круглыми и плоскими кусочками, майонез, сырю" +
                "Выпекать в духовке 30 минут при 180 градусах.");
        testRecipe3.setName("Мясо по-французски");
        testRecipe3.setIngredients(Arrays.asList(
                new Ingredient("курица", 500, "г"),
                new Ingredient("картофель", 500, "г"),
                new Ingredient("сыр", 300, "г"),
                new Ingredient("лук", 3, "шт"),
                new Ingredient("майонез", 1, "пак")
        ));

        Recipe testRecipe4 = new Recipe();
        testRecipe4.setCategory(CategoryEnum.SOUP);
        testRecipe4.setDescription("В кипящий бульон добавить сырую картошку, лук и марковку, грибы, зелень и приправы," +
                "Варить до готовности,подать со смятаной.");
        testRecipe4.setName("Грибной суп");
        testRecipe4.setIngredients(Arrays.asList(
                new Ingredient("бульон", 1, "л"),
                new Ingredient("картофель", 500, "г"),
                new Ingredient("морковь", 1, "шт"),
                new Ingredient("лук", 2, "шт"),
                new Ingredient("приправы", 1, "пак")
        ));

        Recipe testRecipe5 = new Recipe();
        testRecipe5.setCategory(CategoryEnum.SOUP);
        testRecipe5.setDescription("В бульон положить капусту,картошку,марковь и лук,томатную пасту и готовить до мягкой капусты.");
        testRecipe5.setName("Борщ");
        testRecipe5.setIngredients(Arrays.asList(
                new Ingredient("бульон", 500, "г"),
                new Ingredient("картофель", 500, "г"),
                new Ingredient("морковь", 1, "шт"),
                new Ingredient("лук", 3, "шт"),
                new Ingredient("капуста", 500, "г"),
                new Ingredient("Томатная паста", 3,"л")
        ));

        recipeMap.put(testRecipe.getName(), testRecipe);
        recipeMap.put(testRecipe1.getName(), testRecipe1);
        recipeMap.put(testRecipe2.getName(), testRecipe2);
        recipeMap.put(testRecipe3.getName(), testRecipe3);
        recipeMap.put(testRecipe4.getName(), testRecipe4);
        recipeMap.put(testRecipe5.getName(), testRecipe5);
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
