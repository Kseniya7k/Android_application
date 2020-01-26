package com.example.myapplication.enums;

public enum CategoryEnum {
    HOT("Горячее"),
    DESSERT("Десерты"),
    SOUP("Супы"),
    SNACK("Закуски"),
    SALAD("Салаты"),
    DRINK("Напитки");

    private String value;

    CategoryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
