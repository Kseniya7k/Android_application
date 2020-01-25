package com.example.myapplication.enums;

public enum CategoryEnum {
    HOT("Горячее"),
    DESSERT("Десерт"),
    SOUP("Суп"),
    SNACK("Закуски"),
    SALAD("Салат"),
    DRINK("Напитки");

    private String value;

    CategoryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
