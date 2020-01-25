package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.adapter.IngredientListAdapter;
import com.example.myapplication.model.Recipe;
import com.example.myapplication.utils.AppUtil;

public class RecipeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        String recipeName = getIntent().getStringExtra("recipeName");
        Recipe recipe = AppUtil.getRecipeByName(recipeName);
        IngredientListAdapter ingAdapter = new IngredientListAdapter(RecipeActivity.this);
        ingAdapter.addAll(recipe.getIngredients());

        final TextView mainName = findViewById(R.id.recipe_main_name);
        final ListView ingredientsView = findViewById(R.id.recipe_ing_list);
        final TextView description = findViewById(R.id.recipe_description);
        final Button deleteBtn = findViewById(R.id.delete_recipe);

        mainName.setText(recipeName);
        description.setText(recipe.getDescription());
        ingredientsView.setAdapter(ingAdapter);
        deleteBtn.setOnClickListener(view -> {
            AppUtil.deleteRecipe(recipeName);
            startActivity(new Intent(RecipeActivity.this, MainActivity.class));
        });
    }
}
