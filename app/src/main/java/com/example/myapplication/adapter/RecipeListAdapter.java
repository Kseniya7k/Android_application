package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.RecipeActivity;
import com.example.myapplication.model.Recipe;


public class RecipeListAdapter extends ArrayAdapter<Recipe> {

    public RecipeListAdapter(Context context) {
        super(context, R.layout.recipe_name);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Context context = getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_name, null);
        Recipe recipe = getItem(position);
        TextView textView = view.findViewById(R.id.name_test_recipe);

        textView.setText(recipe.getName());
        textView.setOnClickListener(tv -> {
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("recipeName", recipe.getName());
            context.startActivity(intent);
        });

        return view;
    }
}
