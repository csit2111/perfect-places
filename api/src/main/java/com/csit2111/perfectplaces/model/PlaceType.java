package com.csit2111.perfectplaces.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place_type")
public class PlaceType {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "type")
    Collection<PlaceTag>  tag;

    public PlaceType() {
    }

    public PlaceType(String name, Collection<PlaceTag> tag) {
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
    public Collection<PlaceTag> getTag() {
        return tag;
    }

    public void setTag(Collection<PlaceTag> tag) {
        this.tag = tag;
    }
}
