package com.csit2111.perfectplaces.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "region")
    private Collection<Place> place;

    private String name;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    public Collection<Place> getPlace() {
        return place;
    }

    public void setPlace(Collection<Place> place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
