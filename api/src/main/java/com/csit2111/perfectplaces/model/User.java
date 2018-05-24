package com.csit2111.perfectplaces.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private Collection<Comment>  comment;

    public User() {
    }

    public User(String login, String password, String email, Collection<Comment>  comment) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.comment = comment;
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
        password.hashCode();
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public Collection<Comment>  getComment() {
        return comment;
    }

    public void setComment(Collection<Comment>  comment) {
        this.comment = comment;
    }
}
