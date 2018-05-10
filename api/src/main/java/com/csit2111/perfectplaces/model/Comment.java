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
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Place place;

    private int rateValue;

    @OneToOne
    //@JoinTable(name = "place")
    @JoinColumn(name = "id")
    private User userId;

    public Comment(String description, Place place, int rateValue, User userId) {
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
