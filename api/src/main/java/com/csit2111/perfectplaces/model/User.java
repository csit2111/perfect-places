package com.csit2111.perfectplaces.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    /*OneToOne
    @JoinColumn(name = "user_id")
    private Comment commentId;*/
    @OneToMany(mappedBy = "userId")
    private Collection<Comment> comments;


    public User() {
    }

    public User(String login, String password, String email, Collection<Comment> comments) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
