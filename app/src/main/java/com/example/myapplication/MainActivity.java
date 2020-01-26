package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.enums.CategoryEnum;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private View.OnClickListener buttonListener = v -> {
        Intent intent = new Intent(MainActivity.this, RecipeListActivity.class);
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.hot:
                bundle.putSerializable("category", CategoryEnum.HOT);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.dessert:
                bundle.putSerializable("category", CategoryEnum.DESSERT);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.salad:
                bundle.putSerializable("category", CategoryEnum.SALAD);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.snack:
                bundle.putSerializable("category", CategoryEnum.SNACK);
                intent.putExtras(bundle);
                startActivity(intent);                   break;
            case R.id.soup:
                bundle.putSerializable("category", CategoryEnum.SOUP);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.drink:
                bundle.putSerializable("category", CategoryEnum.DRINK);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.add:
                startActivity(new Intent(MainActivity.this, EditActivity.class));
                break;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Integer> ids = Arrays.asList(R.id.hot, R.id.dessert, R.id.salad, R.id.snack, R.id.drink, R.id.add, R.id.soup);

        for (Integer id : ids) {
            findViewById(id).setOnClickListener(buttonListener);
        }
    }


}
