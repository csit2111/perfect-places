package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "place_tag")
public class PlaceTag {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "id")
    private PlaceType typeId;

    @OneToOne(mappedBy = "tagId")
    private Place place;

    public PlaceTag() {
    }

    public PlaceTag(String name, PlaceType typeId, Place place) {
        this.name = name;
        this.typeId = typeId;
        this.place = place;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public PlaceType getTypeId() {
        return typeId;
    }

    public void setTypeId(PlaceType typeId) {
        this.typeId = typeId;
    }
}
