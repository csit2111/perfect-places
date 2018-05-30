package com.example.nya.happymap;


public class Type {
    private int id;
    private String name;

    public Type (int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setIdType(int id){
        this.id = id;
    };

    public void setNameType(String name){
        this.name = name;
    };

    public int getIdType(){
        return this.id;
    };

    public String getNameType(){
        return this.name;
    };
}

