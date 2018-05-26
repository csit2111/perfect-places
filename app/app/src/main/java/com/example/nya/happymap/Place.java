package com.example.nya.happymap;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Place {
    private int id;
    private String name;
    private String description;
    private Region region;
    private Tag tag;
    private double latitude;
    private double longitude;
    private String contacts;
    private String link;
    private ArrayList<Comment> comments;
    private ArrayList<Image> photos;


    public Place(String n, Image p){
        this.name = n;
        this.addPhoto(p);
    };


    public Place(int id, String name, String desc, Region reg, Tag t, double lat,
                 double lng, String cont, String link, ArrayList<Comment> comm, ArrayList<Image> ph) {
        this.name = name;
        this.id = id;
        this.description = desc;
        this.region = reg;
        this.tag = t;
        this.latitude = lat;
        this.longitude = lng;
        this.contacts = cont;
        this.link = link;
        this.photos = ph;
        this.comments = comm;
    }

    public Place() {

    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Image> getPhotos() {
        return photos;
    }

    public double getLat() {
        return latitude;
    }

    public double getLog() {
        return longitude;
    }

    public Region getRegion() {
        return region;
    }

    public String getContacts() {
        return contacts;
    }

    public String getLink() {
        return link;
    }

    public Tag getTag() {
        return tag;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotos(ArrayList<Image> photos) {
        this.photos = photos;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setLg(double lg) {
        this.longitude = lg;
    }

    public void setLt(double lt) {
        this.latitude = lt;
    }

    public void setId(int id) {
        this.id = id;
    }

    //получение координат для карты
    public LatLng getPosition(){
        return new LatLng(this.getLat(), this.getLog());
    }

    public void addPhoto(Image p){
        photos.add(p);
    }

}

