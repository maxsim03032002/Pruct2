package com.example.demo.models;


import java.sql.Date;

public class Human {

    private int id;
    private String  lastName;
    private float height;
    private boolean gender;
    private Date birthday;
    private double weight;
    private int views;

    public Human(int id, String lastName, float height, boolean gender, Date birthday, double weight) {
        this.id = id;
        this.lastName = lastName;
        this.height = height;
        this.gender = gender;
        this.birthday = birthday;
        this.weight = weight;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
