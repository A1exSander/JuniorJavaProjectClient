package com.example.myapplication2.entity;

public class User {
    private String login;
    private String password;
    private double weight;
    private double height;
    private int age;
    private String gender;


    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
