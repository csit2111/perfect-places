package com.csit2111.perfectplaces.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "placeId")
    private Place place;

    private int rateValue;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Comment(String description, Place place, int rateValue, User userId) {
        this.description = description;
        this.place = place;
        this.rateValue = rateValue;
        this.user = userId;
    }

    public Comment() {
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

    @JsonIgnore
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getRateValue() {
        return rateValue;
    }

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
