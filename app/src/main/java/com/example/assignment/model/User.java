package com.example.assignment.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    private String userName;
    @SerializedName("password")
    private String userPassword;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
