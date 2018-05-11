package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "regionId")
    private Place place;

    private String name;

    public Region() {
    }

    public Region(Place place, String name) {
        this.place = place;
        this.name = name;
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
}
