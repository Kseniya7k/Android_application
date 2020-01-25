package com.example.myapplication.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.Ingredient;

public class IngredientListAdapter extends ArrayAdapter<Ingredient> {

    public IngredientListAdapter(Context context) {
        super(context, R.layout.ingredient);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.ingredient, null);
        final Ingredient ingredient = getItem(position);

        ((TextView) view.findViewById(R.id.i_name)).setText(ingredient.getName());
        ((TextView) view.findViewById(R.id.i_amount)).setText(String.valueOf(ingredient.getAmount()));
        ((TextView) view.findViewById(R.id.i_unit)).setText(ingredient.getUnit());

        return view;
    }
}
