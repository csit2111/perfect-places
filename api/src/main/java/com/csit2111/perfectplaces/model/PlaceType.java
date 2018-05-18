package com.csit2111.perfectplaces.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "place_type")
public class PlaceType {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne(mappedBy = "type")
    PlaceTag tag;

    public PlaceType() {
    }

    public PlaceType(String name, PlaceTag tag) {
        this.name = name;
        this.tag = tag;
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

    @JsonIgnore
    public PlaceTag getTag() {
        return tag;
    }

    public void setTag(PlaceTag tag) {
        this.tag = tag;
    }
}
