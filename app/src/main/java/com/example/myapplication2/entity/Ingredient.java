package com.example.myapplication2.entity;

public class Ingredient {
    private final String ingredientName;
    private final double energy;
    private final double protein;
    private final double fat;
    private final double carbohydrates;
    private final double sugar;
    private final double fatSaturated;
    private final double fatPolyUnsaturated;
    private final double fatMonoUnsaturated;
    private final double glycemicIndex;
    private final double glycemicLoad;


    public Ingredient(IngredientBuilder builder){
        this.ingredientName = builder.ingredientName;
        this.energy = builder.energy;
        this.protein = builder.protein;
        this.fat = builder.fat;
        this.carbohydrates = builder.carbohydrates;
        this.sugar = builder.sugar;
        this.fatSaturated = builder.fatSaturated;
        this.fatPolyUnsaturated = builder.fatPolyUnsaturated;
        this.fatMonoUnsaturated = builder.fatMonoUnsaturated;
        this.glycemicIndex = builder.glycemicIndex;
        this.glycemicLoad = builder.glycemicLoad;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getEnergy() {
        return energy;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getSugar() {
        return sugar;
    }

    public double getFatSaturated() {
        return fatSaturated;
    }

    public double getFatPolyUnsaturated() {
        return fatPolyUnsaturated;
    }

    public double getFatMonoUnsaturated() {
        return fatMonoUnsaturated;
    }

    public double getGlycemicIndex() {
        return glycemicIndex;
    }

    public double getGlycemicLoad() {
        return glycemicLoad;
    }

    public static class IngredientBuilder {
        private final String ingredientName;
        private final double energy;
        private final double protein;
        private final double fat;
        private final double carbohydrates;
        private double sugar = 0;
        private double fatSaturated = 0;
        private double fatPolyUnsaturated = 0;
        private double fatMonoUnsaturated = 0;
        private double glycemicIndex = 0;
        private double glycemicLoad = 0;

        public IngredientBuilder(String ingredientName, double energy, double protein, double fat, double carbohydrates) {
            this.energy = energy;
            this.protein = protein;
            this.fat = fat;
            this.carbohydrates = carbohydrates;
            this.ingredientName = ingredientName;
        }


        public void setSugar(double sugar) {
            this.sugar = sugar;
        }

        public void setFatSaturated(double fatSaturated) {
            this.fatSaturated = fatSaturated;
        }
        public void setFatPolyUnsaturated(double fatPolyUnsaturated) {
            this.fatPolyUnsaturated = fatPolyUnsaturated;
        }

        public void setFatMonoUnsaturated(double fatMonoUnsaturated) {
            this.fatMonoUnsaturated = fatMonoUnsaturated;
        }


        public void setGlycemicIndex(double glycemicIndex) {
            this.glycemicIndex = glycemicIndex;
        }

        public void setGlycemicLoad(double glycemicLoad) {
            this.glycemicLoad = glycemicLoad;
        }

        public Ingredient build(){
            return new Ingredient(this);
        }

    }
}