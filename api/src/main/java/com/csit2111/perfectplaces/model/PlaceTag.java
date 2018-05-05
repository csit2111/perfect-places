package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "placeTag")
public class PlaceTag {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "id")
    private long typeId;

    public PlaceTag() {
    }

    public PlaceTag(long id, String name, long typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
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

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }
}
