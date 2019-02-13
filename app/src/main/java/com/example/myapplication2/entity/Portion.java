package com.example.myapplication2.entity;


public class Portion {
    private int portionId;
    private int userId;
    private int ingredientId;
    private double mass;
    private String BrDinSup;
    private String date;

    public int getPortionId() {
        return portionId;
    }

    public void setPortionId(int portionId) {
        this.portionId = portionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getBrDinSup() {
        return BrDinSup;
    }

    public void setBrDinSup(String brDinSup) {
        BrDinSup = brDinSup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "portion{" +
                "portionId=" + portionId +
                ", userId=" + userId +
                ", ingredientId=" + ingredientId +
                ", mass=" + mass +
                ", BrDinSup='" + BrDinSup + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}