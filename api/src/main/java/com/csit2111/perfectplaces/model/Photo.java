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
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Place placeId;

    public Photo() {
    }

    public Photo(String imagePath) {
        this.imagePath = imagePath;
        //this.placeId = placeId;
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
        return placeId;
    }

    public void setPlace(Place placeId) {
        this.placeId = placeId;
    }
}
