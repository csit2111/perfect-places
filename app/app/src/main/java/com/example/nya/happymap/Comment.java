package com.example.nya.happymap;

public class Comment {
    private int id;
    private String description;
    private int rateValue;
    private User user;

    public Comment(int id, String d, int r, User u){
        this.id = id;
        this.description = d;
        this.rateValue = r;
        this.user = u;
    }

    public Comment(){};

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getRateValue() {
        return rateValue;
    }

    public User getUser() {
        return user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
