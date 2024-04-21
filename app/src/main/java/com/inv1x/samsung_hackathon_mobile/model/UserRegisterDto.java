package com.inv1x.samsung_hackathon_mobile.model;

public class UserRegisterDto {
    private long id;
    private String username;
    private String email;
    private String password;

    public UserRegisterDto(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
