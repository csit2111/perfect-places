package com.example.nya.happymap;


public class Region {
    private int id;
    private String name;

    public Region (int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setIdRegion(int id){
        this.id = id;
    };

   public void setNameRegion(String name){
       this.name = name;
   };

    public int getIdRexgion(){
        return this.id;
    };

    public String getNameRexgion(){
        return this.name;
    };
};


