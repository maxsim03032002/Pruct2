package com.example.demo.models;





public class PublishingHouse {


    private int id;
    private String  publishName;
    private String publishAddress;
    private String telephoneNumber;
    private String email;
    private double rating;

    public PublishingHouse(int id, String publishName, String publishAddress, String telephoneNumber, String email, double rating) {
        this.id = id;
        this.publishName = publishName;
        this.publishAddress = publishAddress;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.rating = rating;
    }

    public PublishingHouse() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPublishAddress() {
        return publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
