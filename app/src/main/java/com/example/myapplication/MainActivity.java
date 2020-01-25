package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private View.OnClickListener buttonListener = v -> {
        switch (v.getId()) {
            case R.id.hot:
                System.out.println("HOT clicked");
                break;
            case R.id.dessert:
                System.out.println("DESSERT clicked");
                break;
            case R.id.salad:
                System.out.println("SALAD clicked");
                break;
            case R.id.snack:
                System.out.println("SNACK clicked");
                break;
            case R.id.soup:
                System.out.println("SOUP clicked");
                break;
            case R.id.drink:
                System.out.println("DRINK clicked");
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
