package com.csit2111.perfectplaces.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment  implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Place place;

    @Column(name = "rate_value")
    private int rateValue;

    @OneToOne(mappedBy = "commentId")
    //@JoinTable(name = "place"
   // @Column(name = "user_id")
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User userId;

    public Comment() {
    }


    public Comment(String description, Place place, int rateValue, User userId) {
        this.description = description;
        this.place = place;
        this.rateValue = rateValue;
        this.userId = userId;
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
