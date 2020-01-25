package com.example.myapplication.model;

public class Ingredient {

    private String name;
    private Integer amount;
    private String unit;

    public Ingredient(String name, Integer amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
