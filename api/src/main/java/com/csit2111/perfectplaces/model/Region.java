package com.csit2111.perfectplaces.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "region")
public class Region implements Serializable {

    @Id
   // @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "regionId")
    private Place place;

    @Column(name = "name")
    private String name;

    public Region() {
    }

    public Region(String name) {
       // this.place = place;
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
