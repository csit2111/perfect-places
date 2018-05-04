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
    @JoinColumn(name = "photos")
    private long photoId;

    public Photo() {
    }

    public Photo(long id, String imagePath, long photoId) {
        this.id = id;
        this.imagePath = imagePath;
        this.photoId = photoId;
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

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }
}
