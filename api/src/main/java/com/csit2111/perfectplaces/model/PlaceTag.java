package com.csit2111.perfectplaces.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place_tag")
public class PlaceTag {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private PlaceType type;

    @OneToMany(mappedBy = "tag")
    private Collection<Place> place;

    public PlaceTag() {
    }

    public PlaceTag(String name, PlaceType type, Collection<Place> place) {
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

    @JsonIgnore
    public Collection<Place> getPlace() {
        return place;
    }

    public void setPlace(Collection<Place> place) {
        this.place = place;
    }
}
