package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "")
    private long commentId;

    private int rateValue;

    @OneToOne
    @JoinColumn(name = "commentId")
    private long userId;


}
