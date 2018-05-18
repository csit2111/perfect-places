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
    @MapsId
    @JoinColumn(name = "typeId")
    private PlaceType type;

    @OneToOne(mappedBy = "tag")
    private Place place;

    public PlaceTag() {
    }

    public PlaceTag(String name, PlaceType type, Place place) {
        this.name = name;
        this.type = type;
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

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
