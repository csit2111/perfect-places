package com.csit2111.perfectplaces.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String password;

    private String email;

    @OneToOne(mappedBy = "userId")
    private long commentId;

    public User() {
    }

    public User(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
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
}
