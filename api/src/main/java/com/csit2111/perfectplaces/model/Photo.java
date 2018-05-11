package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue
    private long id;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "placeId")
    private Place place;

    public Photo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
