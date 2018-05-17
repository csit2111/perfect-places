package com.csit2111.perfectplaces.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "place")
public class Place implements Serializable {

    @Id
    @GeneratedValue
    private  long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Region regionId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private PlaceTag tagId;

    @Column(name = "lat")
    private  float lat;

    @Column(name = "lon")
    private  float lon;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "place")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "placeId")
    private Collection<Photo> photos;

    public Place() {
    }

    public Place(String name, String description, Region regionId, PlaceTag tagId, float latitude, float longitude, String contacts, String link, Collection<Comment> comments, Collection<Photo> photos) {
        this.name = name;
        this.description = description;
        this.regionId = regionId;
        this.tagId = tagId;
        this.lat = latitude;
        this.lon = longitude;
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

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    public PlaceTag getTagId() {
        return tagId;
    }

    public void setTagId(PlaceTag tagId) {
        this.tagId = tagId;
    }

    public float getLatitude() {
        return lat;
    }

    public void setLatitude(float latitude) {
        this.lat = latitude;
    }

    public float getLongitude() {
        return lon;
    }

    public void setLongitude(float longitude) {
        this.lon = longitude;
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
