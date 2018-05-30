package com.example.nya.happymap;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;

    public User(int id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public void setUserId(int id) {
        this.id = id;
    };

    public void setUserLogin(String l) {
        this.login = l;
    };

    public void setUserPassword(String p) {
        this.password = p;
    };

    public void setUserEmail(String e) {
        this.email = e;
    };

    public int getUserId() {
        return this.id;
    };

    public String getUserLogin() {
        return this.login;
    };

    public String getUserPassword() {
        return this.password;
    };

    public String getUserEmail() {
        return this.email;
    };
}