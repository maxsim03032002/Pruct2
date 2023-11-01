package com.example.demo.models;


import java.sql.Date;


public class Post {

    public Post(int id, double title, boolean anons, String full_text, Date dateAnons, int countReaders) {
        this.id = id;
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.dateAnons = dateAnons;
        this.countReaders = countReaders;
    }

    public Post() {
    }


    private int id;
    private String  full_text;
    private double title;
    private boolean anons;
    private Date dateAnons;
    private int countReaders;
    private int views;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTitle() {
        return title;
    }

    public void setTitle(double title) {
        this.title = title;
    }

    public boolean getAnons() {
        return anons;
    }

    public void setAnons(boolean anons) {
        this.anons = anons;
    }

    public String getFull_text() {return full_text;}

    public void setFull_text(String full_text) {this.full_text = full_text;}

    public Date getDateAnons() {
        return dateAnons;
    }

    public void setDateAnons(Date dateAnons) {
        this.dateAnons = dateAnons;
    }

    public int getCountReaders() {
        return countReaders;
    }

    public void setCountReaders(int countReaders) {
        this.countReaders = countReaders;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


}
