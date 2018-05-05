package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "comments")
    private Place place;

    private int rateValue;

    //TODO Error:(24, 13) 'One To One' attribute type should not be 'long'
    @OneToOne
    @JoinColumn(name = "id")
    private long userId;

    public Comment(String description, Place place, int rateValue, long userId) {
        this.description = description;
        this.place = place;
        this.rateValue = rateValue;
        this.userId = userId;
    }

    public Comment() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
