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
    private Comment commentId;


    public User() {
    }

    public User(String login, String password, String email, Comment commentId) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.commentId = commentId;
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

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
