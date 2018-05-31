package com.example.nya.happymap;


public class Tag {
    private int id;
    private String name;
    private Type type;

    public Tag (int id, String name, Type type){
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public void setIdTag(int id){
        this.id = id;
    };

    public void setNameTag(String name){
        this.name = name;
    };
    public void setTypeTag(Type type){
        this.type = type;
    };

    public int getIdTag(){
        return this.id;
    };

    public String getNameTag(){
        return this.name;
    };

    public Type getTypeTag(){
        return this.type;
    };
}
