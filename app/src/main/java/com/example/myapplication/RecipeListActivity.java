package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.RecipeListAdapter;
import com.example.myapplication.model.Recipe;
import com.example.myapplication.utils.AppUtil;

import java.util.ArrayList;
import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    private List<Recipe> recipes;
    private ListView recipeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        recipes = new ArrayList<>(AppUtil.getAllRecipes());
        recipeListView = findViewById(R.id.recipe_list);
        final RecipeListAdapter recipeListAdapter = new RecipeListAdapter(RecipeListActivity.this);
        recipeListView.setAdapter(recipeListAdapter);
        recipeListAdapter.addAll(recipes);
    }
}
