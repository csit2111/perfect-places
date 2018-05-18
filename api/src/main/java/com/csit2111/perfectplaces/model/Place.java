package com.csit2111.perfectplaces.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "regionId")
    private Region region;

    @OneToOne
    @MapsId
    @JoinColumn(name = "tagId")
    private PlaceTag tag;

    private  float latitude;

    private  float longitude;

    private String contacts;

    private String link;

    @OneToMany(mappedBy = "place")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "place")
    private Collection<Photo> photos;

    public Place() {
    }

    public Place(String name, String description, Region region, PlaceTag tag, float latitude, float longitude, String contacts, String link, Collection<Comment> comments, Collection<Photo> photos) {
        this.name = name;
        this.description = description;
        this.region = region;
        this.tag = tag;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public PlaceTag getTag() {
        return tag;
    }

    public void setTag(PlaceTag tag) {
        this.tag = tag;
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
