package com.example.myapplication.model;


import com.example.myapplication.enums.CategoryEnum;

import java.util.List;

public class Recipe {

    private String name;
    private List<Ingredient> ingredients;
    private String description;
    private CategoryEnum category;

    public Recipe() {
    }

    public Recipe(String name, List<Ingredient> ingredients, String description, CategoryEnum category) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

}
