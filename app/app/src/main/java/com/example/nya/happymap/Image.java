package com.example.nya.happymap;


public class Image {
    private int id;
    private String imagePath;

    public Image(int id, String imagePath){
        this.id = id;
        this.imagePath = imagePath;
    };

    public int getImageId(){
        return this.id;
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public void setImagePath(String im){
        this.imagePath = im;
    };

    public void setImageId(int id){
        this.id = id;
    }
}
