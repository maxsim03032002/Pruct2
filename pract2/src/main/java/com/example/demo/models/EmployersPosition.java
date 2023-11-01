package com.example.demo.models;


import java.sql.Date;

public class EmployersPosition {

    private int id;
    private String positionName;
    private float salary;
    private boolean gender;
    private Date birthday;
    private double weight;

    public EmployersPosition(int id, String positionName, float salary, boolean gender, Date birthday, double weight) {
        this.id = id;
        this.positionName = positionName;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        this.weight = weight;
    }

    public EmployersPosition() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
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


}

