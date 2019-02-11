package com.example.myapplication2.entity;

public class ReveivedIngredient {
    private int id;
    private String ingredientName;
    private double energy;
    private double protein;
    private double fat;
    private double carbohydrates;
    private double sugar;
    private double fatSaturated;
    private double fatPolyUnsaturated;
    private double fatMonoUnsaturated;
    private double glycemicIndex;
    private double glycemicLoad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getFatSaturated() {
        return fatSaturated;
    }

    public void setFatSaturated(double fatSaturated) {
        this.fatSaturated = fatSaturated;
    }

    public double getFatPolyUnsaturated() {
        return fatPolyUnsaturated;
    }

    public void setFatPolyUnsaturated(double fatPolyUnsaturated) {
        this.fatPolyUnsaturated = fatPolyUnsaturated;
    }

    public double getFatMonoUnsaturated() {
        return fatMonoUnsaturated;
    }

    public void setFatMonoUnsaturated(double fatMonoUnsaturated) {
        this.fatMonoUnsaturated = fatMonoUnsaturated;
    }

    public double getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(double glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public double getGlycemicLoad() {
        return glycemicLoad;
    }

    public void setGlycemicLoad(double glycemicLoad) {
        this.glycemicLoad = glycemicLoad;
    }
}
