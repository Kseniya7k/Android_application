package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.IngredientListAdapter;
import com.example.myapplication.enums.CategoryEnum;
import com.example.myapplication.model.Ingredient;
import com.example.myapplication.model.Recipe;
import com.example.myapplication.utils.AppUtil;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    static List<String> categories = new ArrayList<>();

    private ArrayAdapter<Ingredient> ingAdapter;
    private Spinner spinner;
    private EditText ingredName, ingredAmount, ingredUnit, recipeName, description;
    private List<Ingredient> ingredients = new ArrayList<>();

    static {
        for (CategoryEnum v : CategoryEnum.values()) {
            categories.add(v.getValue());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initEditTexts();
        initIngredientList();
        initSpinner();
        initButtons();
    }

    private void initIngredientList() {
        final ListView ingredientListView = findViewById(R.id.ingredient_list);
        ingAdapter = new IngredientListAdapter(EditActivity.this);
        ingredientListView.setAdapter(ingAdapter);
    }

    private void initEditTexts() {
        recipeName = findViewById(R.id.recipe_name);
        description = findViewById(R.id.description);
        ingredName = findViewById(R.id.ingredient_name);
        ingredAmount = findViewById(R.id.amount);
        ingredUnit = findViewById(R.id.unit);
    }


    private void initButtons() {
        Button saveBtn = findViewById(R.id.save_recipe);
        Button cancelBtn = findViewById(R.id.cancel);
        Button addIngredients = findViewById(R.id.plus);

        addIngredients.setOnClickListener(view -> {
            Ingredient newIng = new Ingredient(ingredName.getText().toString(),
                    Integer.parseInt(ingredAmount.getText().toString()),
                    ingredUnit.getText().toString());
            ingredients.add(newIng);
            ingAdapter.add(newIng);
        });

        saveBtn.setOnClickListener(view -> {
            CategoryEnum category = getCategoryType(spinner.getSelectedItem().toString());
            Recipe recipe = new Recipe(recipeName.getText().toString(), ingredients,
                    description.getText().toString(), category);
            AppUtil.addRecipe(recipe);
            startActivity(new Intent(EditActivity.this, RecipeListActivity.class));
        });

        cancelBtn.setOnClickListener(view -> {
            startActivity(new Intent(EditActivity.this, MainActivity.class));
        });
    }

    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Выберите категорию");
    }


    private CategoryEnum getCategoryType(String val) {
        for (CategoryEnum category: CategoryEnum.values()) {
            if (category.getValue().equals(val)) {
                return category;
            }
        }
        return null;
    }
}


