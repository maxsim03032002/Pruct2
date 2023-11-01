package com.example.demo.models;


import java.sql.Date;


public class Project {

    private int id;
    private Date  deadlines;
    private String description;
    private float cost;
    private String projectName;
    private double employersCount;
    private int views;

    public Project(int id, Date deadlines, String description, float cost, String projectName, double employersCount) {
        this.id = id;
        this.deadlines = deadlines;
        this.description = description;
        this.cost = cost;
        this.projectName = projectName;
        this.employersCount = employersCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(Date deadlines) {
        this.deadlines = deadlines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getEmployersCount() {
        return employersCount;
    }

    public void setEmployersCount(double employersCount) {
        this.employersCount = employersCount;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}

