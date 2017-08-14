package com.github.xkylin.example.springmvc.entities;

public class User {

    private Long id;

    private String userName;

    private String password;

    private byte [] headImage;

    public User() {
    }

    public User(Long id, String userName, String password, byte[] headImage) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.headImage = headImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getHeadImage() {
        return headImage;
    }

    public void setHeadImage(byte[] headImage) {
        this.headImage = headImage;
    }
}
