package com.inv1x.samsung_hackathon_mobile.model;

import android.widget.EditText;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthDto {
    private String email;
    private String password;

    public UserAuthDto(EditText loginInput, EditText passwordInput) {
        this.email = loginInput.toString();
        this.password = passwordInput.toString();
    }
}
