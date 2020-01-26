package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.RecipeListAdapter;
import com.example.myapplication.enums.CategoryEnum;
import com.example.myapplication.model.Recipe;
import com.example.myapplication.utils.AppUtil;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    private List<Recipe> recipes;
    private ListView recipeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        CategoryEnum category = (CategoryEnum) bundle.getSerializable("category");

        setTitle(category.getValue());
        setContentView(R.layout.activity_recipes_list);
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(RecipeListActivity.this);
        recipes = AppUtil.getRecipesByCategory(category);
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
            recipeListAdapter.add(recipe);
        }

        recipeListView = findViewById(R.id.recipe_list);
        recipeListView.setAdapter(recipeListAdapter);
    }
}
