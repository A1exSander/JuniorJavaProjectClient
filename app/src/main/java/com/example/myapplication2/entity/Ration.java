package com.example.myapplication2.entity;

import java.util.Calendar;

public class Ration {
    private int rationID;
    private int userID;
    private int ingredientID;
    private int mass;
    private String BrDinSup;
    private String date;

    public int getRationID() {
        return rationID;
    }

    public void setRationID(int rationID) {
        this.rationID = rationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
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
        return "Ration{" +
                "rationID=" + rationID +
                ", userID=" + userID +
                ", ingredientID=" + ingredientID +
                ", mass=" + mass +
                ", BrDinSup='" + BrDinSup + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}