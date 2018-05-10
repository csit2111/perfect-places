package com.csit2111.perfectplaces.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue
    private  long id;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name = "id")
    private long regionId;

    private long tagId;

    private  float latitude;

    private  float longitude;

    private String contacts;

    private String link;

    @OneToMany(mappedBy = "place")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "placeId")
    private Collection<Photo> photos;

    public Place() {
    }

    public Place(String name, String description, long regionId, long tagId, float latitude, float longitude, String contacts, String link, Collection<Comment> comments, Collection<Photo> photos) {
        this.name = name;
        this.description = description;
        this.regionId = regionId;
        this.tagId = tagId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contacts = contacts;
        this.link = link;
        this.comments = comments;
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }
}
