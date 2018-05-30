package com.example.nya.happymap;


public class Category {
    private String name;
    private String imageURL;


    public Category(String name, String imURL) {
        this.name = name;
        this.imageURL = imURL;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setName(String n) {name = n;}

    public void setImageURL(String imURL) {
        imageURL = imURL;
    }
}

